package com.app.mongo.controllers;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.mongo.entity.DailyExpense;
import com.app.mongo.entity.SourceExpenseReport;
import com.app.mongo.services.DailyExpenseService;
import com.app.mongo.services.MasterSourceService;
import com.app.mongo.services.MonthlyExpenseService;
import com.app.mongo.services.PaginationService;
import com.app.mongo.services.StockService;

@Controller
@RequestMapping(path = "/")
@CrossOrigin(origins = "*")
public class BudgetController {

    @Autowired
	PaginationService paginationService;

	@Autowired
	private DailyExpenseService dailyExpenseService;

	@Autowired
	private MasterSourceService masterSourceService;
	
	@GetMapping("/ping")
	public ResponseEntity<String> getPing() {
		
		return new ResponseEntity<String>("PingedSuccess!", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllExpenseItems")
	public ResponseEntity<List<DailyExpense>> getAllExpenseItems() {
		
		List<DailyExpense> allPages = dailyExpenseService.findAll();
		//long totalElements = allPages.getTotalElements();
		//int totalPages = allPages.getTotalPages();
		

		return new ResponseEntity<List<DailyExpense>> (allPages, HttpStatus.ACCEPTED);
	}

	@GetMapping("/addExpenseItemScreen")
	public String addExpenseItemScreen(Model model, @RequestParam("loginUser") String loginUser) {
		
		model.addAttribute("masterSource", masterSourceService.getMasterSource());
		//model.addAttribute("loginUser", loginUser);
		model.addAttribute("dailyExpenseDetails", new DailyExpense());
		//model.addAttribute("transactionDate", paginationService.getSystemDateTime());
		System.out.println("From Controller : "+paginationService.getSystemDateTime());
		return "addExpense";
	}

	@PostMapping("/addExpenseItem")
	public String addNewItemSave(Model model, DailyExpense dailyExpense) {
		
		System.out.println(dailyExpense.toString());
		DailyExpense latestFromDB = dailyExpenseService.findFirstByOrderByIdFieldDesc();
		if(latestFromDB != null) {
			dailyExpense.setId(latestFromDB.getId()+1L);
			
			if (dailyExpense.getTransactionDate().isEmpty()) {
				dailyExpense.setTransactionDate(paginationService.getSystemDateTime());
			}
			if(dailyExpense.getItemPrice()<0) {
				dailyExpense.setTransactionType("CR");
				dailyExpense.setSubTotal((latestFromDB.getSubTotal() - dailyExpense.getItemPrice()));
			}else {
				dailyExpense.setTransactionType("DB");
				dailyExpense.setSubTotal((latestFromDB.getSubTotal() + dailyExpense.getItemPrice()));
			}
				
		}else {
			dailyExpense.setId(1L);
			dailyExpense.setSubTotal(dailyExpense.getItemPrice());
		}
		
		dailyExpenseService.save(dailyExpense);
		model.addAttribute("masterSource", masterSourceService.getMasterSource());		
		model.addAttribute("dailyExpenseDetails", new DailyExpense());
		model.addAttribute("message", "Success");
		return "addExpense";		

	}

	@GetMapping("/dailyExpenseReport")
	public String getDailyReport(Model model, DailyExpense dailyExpense, @RequestParam Optional<Integer> page) {
		//List<DailyExpense> reversed = dailyExpenseService.findAll().stream().collect(Collectors.toList());
		//Collections.reverse(reversed);
		
		//Page<DailyExpense> allPages = dailyExpenseService.findAll().stream().map(a->a).collect(Collectors.toList()).reversed();
		//long totalElements = allPages.getTotalElements();
		//int totalPages = allPages.getTotalPages();
		
		
		int currentPage = page.orElse(0);
		int pageSize = 15;
		
		//Long totalCollection = dailyExpenseService.findTotalCollection();
			

		Page<DailyExpense> allByIdDesc = dailyExpenseService.findAllByPageLimit(currentPage, pageSize);
		
		//List<DailyExpense> allByIdDesc = dailyExpenseService.findAllByIdDesc();

		model.addAttribute("dailyExpenseResult", allByIdDesc);

		model.addAttribute("masterSource", masterSourceService.getMasterSource());	
		
		return "dailyExpenseReport";
	}
	

	@PostMapping("/deleteExpenseById")
	public String deleteItemById(Model model, @RequestParam Integer itemId) {
		System.out.println("data id " + itemId);
		dailyExpenseService.deleteById(itemId);
		//stockService.deleteById(stockDetails.getItemId());
		
		if(model.getAttribute("reversed") == null ) {
			//model.addAttribute("dailyExpenseResult", dailyExpenseService.findAllByIdDesc());
		List<DailyExpense> reversed = dailyExpenseService.findAll().stream().collect(Collectors.toList());
		Collections.reverse(reversed);
		model.addAttribute("dailyExpenseResult", reversed);
		}
		model.addAttribute("masterSource", masterSourceService.getMasterSource());	

		
		return "dailyExpenseReport";
	}

	@GetMapping("/monthlyExpenseReport")
	public String getMonthlyReport(Model model,	@RequestParam Optional<Integer> page) {
		
		//List<DailyExpense> allBySource = dailyExpenseService.getAllBySource();
		/*
		Map<String, Double> allBySource = dailyExpenseService.findAll().stream()
				.collect(Collectors.groupingBy(i -> i.getSource() + " " + YearMonth.from(LocalDateTime.parse(i.getTransactionDate())), 
						Collectors.summingDouble(DailyExpense::getItemPrice)));
		*/
		 Map<String, DoubleSummaryStatistics> allBySource = dailyExpenseService.findAll().stream()
				.collect(Collectors.groupingBy(i -> (i.getSource() + " " + YearMonth.from(LocalDateTime.parse(i.getTransactionDate()))), 
						Collectors.summarizingDouble(DailyExpense::getItemPrice)));
		 
		 System.out.println("allBySource : " +allBySource);
		
		//{BOA-CA 2026-04=2175.0, CITI-CC 2026-03=30.01, Chase-CC 2026-03=136.22, Chase-CC 2026-04=17.67}
		// {BOA-CA 2026-04=DoubleSummaryStatistics{count=1, sum=2175.000000, min=2175.000000, average=2175.000000, max=2175.000000}, CITI-CC 2026-03=DoubleSummaryStatistics{count=2, sum=30.010000, min=5.340000, average=15.005000, max=24.670000}, Chase-CC 2026-03=DoubleSummaryStatistics{count=6, sum=136.220000, min=4.640000, average=22.703333, max=91.220000}, Chase-CC 2026-04=DoubleSummaryStatistics{count=1, sum=17.670000, min=17.670000, average=17.670000, max=17.670000}}
//String source, double amount, String month, double min, double max, String transactions
		
		 List<SourceExpenseReport> serList = new ArrayList<>();
		 allBySource.forEach((key, value)->{
			 SourceExpenseReport ser = new SourceExpenseReport();			
			 String[] source = key.split(" ");
			 ser.setSource(source[0]);
			 ser.setMonth(source[1]);
			 ser.setAmount(value.getSum());
			 ser.setMax(value.getMax());
			 ser.setMin(value.getMin());
			 ser.setTransactions(value.getCount());
			 
			 serList.add(ser);
		});
		
		System.out.println(allBySource);
		
		model.addAttribute("AllExpenseBySource", serList);
		
		return "monthlyExpenseReport";
		

	}


}
