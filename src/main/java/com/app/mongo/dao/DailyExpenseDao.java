package com.app.mongo.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.app.mongo.entity.DailyExpense;
import com.app.mongo.entity.FilterData;
import com.app.mongo.repo.CustomData;
import com.app.mongo.repo.DailyExpenseRepo;



@Repository
public class DailyExpenseDao {

	@Autowired
	private DailyExpenseRepo dailyExpenditureRepo;

	@Autowired
	CustomData customData;
	
	public Iterable<DailyExpense> findByItemName(String itemName) {
		return dailyExpenditureRepo.findByItemName(itemName);

	}
	
/*	public Integer findMaxId() {
		return customData.findMaxCountOfId();
	}*/

	public Optional<DailyExpense> findById(Integer id) {
		return dailyExpenditureRepo.findById(id);
	}
	
	public DailyExpense findFirstByOrderByIdFieldDesc() {
		return dailyExpenditureRepo.findTopByOrderByIdDesc();
	}

	public List<DailyExpense> findAll() {
		//Pageable pageable = PageRequest.of(0, 15);
		return dailyExpenditureRepo.findAll();
	}

	public DailyExpense save(DailyExpense dailyExpenditure) {
		return dailyExpenditureRepo.save(dailyExpenditure);
	}

	public DailyExpense update(DailyExpense dailyExpenditure) {
		return dailyExpenditureRepo.save(dailyExpenditure);
	}

	public void delete(DailyExpense dailyExpenditure) {
		dailyExpenditureRepo.delete(dailyExpenditure);
	}

	public void deleteById(Integer id) {
		dailyExpenditureRepo.deleteById(id);
	}
	
	public List<DailyExpense> findAllByIdDesc() {
		
		List<DailyExpense> dailyExpenseByIdDesc = dailyExpenditureRepo.findAll().stream().collect(Collectors.toList());
		Collections.reverse(dailyExpenseByIdDesc);
		return dailyExpenseByIdDesc;
	}
	
	public Page<DailyExpense> findAllByPageLimit(int start, int limit){
		
		Pageable pageable = PageRequest.of(start, limit, Sort.by("id").descending());
		Page<DailyExpense> latestRecords = dailyExpenditureRepo.findAll(pageable);
		
		return latestRecords;
	}
	
	public Long findTotalCollection() {
		return dailyExpenditureRepo.count();
	}
	/*
	public List<DailyExpense> findDataByDateRange(FilterData filterData) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fromDate = formatter.parse(filterData.getTransactionFromDate());
            Date toDate = formatter.parse(filterData.getTransactionToDate());
            return dailyExpenditureRepo.findDataByDateRange(fromDate, toDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        return null;
	}
	
	public DailyExpense getLatestBySource(String source) {
		return dailyExpenditureRepo.getLatestBySource(source);
	}
	
	public List<DailyExpense> getSortedDataBySelectedItem(FilterData filterData) {
		return dailyExpenditureRepo.findSortedDataBySelectedItem(filterData.getSortSelectItem());		
	}	
	public List<DailyExpense> getFilterdDataBySourceItem(FilterData filterData) {
		return dailyExpenditureRepo.findFilteredDataBySourceItem(filterData.getSourceSelect());		
	}
	public List<DailyExpense> getAllExpenseByMonth() {
	
		List<DailyExpense> dailyExpenseList = new ArrayList<DailyExpense>();
		 List<Object[]> allExpenseByMonth = dailyExpenditureRepo.getAllExpenseByMonth();	
		 for(Object[] row : allExpenseByMonth) {
			 DailyExpense de = new DailyExpense();
			 if(row[2].equals("HOA") || row[2].equals("Internet") || row[2].equals("JEA") || row[2].equals("Mortgage") || row[2].equals("FPL")) {
				 de.setSource("BOA-CA");
			 }else {
				 de.setSource((row[2]).toString());
			 }
					 
			 de.setTransactionDate((row[0]).toString());
			 de.setTransactionType((row[1]).toString());
			 de.setItemName((row[2]).toString());
			 
			 de.setItemPrice(((Double) row[3]).doubleValue());
			 
			 dailyExpenseList.add(de);
			 System.out.println(de);
		 }
		 
		 return dailyExpenseList;
	}
	*/

}
