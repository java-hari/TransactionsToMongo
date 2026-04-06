package com.app.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.mongo.entity.StockDetails;
import com.app.mongo.services.StockService;

@Controller
@RequestMapping(path = "/")
public class StockController {

	@Autowired
	private StockService stockService;

	
	@GetMapping("/resultItem")
	public String stockResultScreen(Model model) {
//int currentPage = 1;
		Page<StockDetails> page = stockService.findAll();
		
		long totalElements = page.getTotalElements();
		int totalPages = page.getTotalPages();
		model.addAttribute("stockDetails", new StockDetails());
		model.addAttribute("stockResult", page.getContent());
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		//model.addAttribute("currentPage", currentPage);
		//model.addAttribute("stockResult", stockService.findAll());

		return "stockData";
	}

	@GetMapping("/addItemScreen")
	public String addNewItemScreen(Model model) {
		model.addAttribute("stockDetails", new StockDetails());
		return "addItem";
	}

	/*@PostMapping("/addItemSave")
	public String addNewItemSave(Model model, StockDetails stockDetails, Errors error) {
		if(error != null && error.getErrorCount() >0) {
			System.out.println("In error page ====================>>");
			model.addAttribute("stockResult", stockService.findAll());
			return "stockData";
		}else {
		Iterable<StockDetails> findByItemName = stockService.findByItemName(stockDetails.getItemName());
			if(findByItemName.iterator().hasNext()) {
				
				findByItemName.forEach(item -> {
					if(item.getItemName().toUpperCase().equals(stockDetails.getItemName().toUpperCase())){
						if(stockDetails.getItemInstock() == null ||item.getItemInstock() == null) {
							stockDetails.setItemInstock(0);
							item.setItemInstock(0);
						}
						int stock = item.getItemInstock() + stockDetails.getItemInstock();
						item.setItemInstock(stock);
						if(stockDetails.getItemPrice() != 0.0) {
							item.setItemPrice(stockDetails.getItemPrice());
						}
						if(!stockDetails.getItemType().equals("none")) {
							item.setItemType(stockDetails.getItemType());
						}
						
					}
					stockService.save(item);	
				});
				
				
		}else {
			stockService.save(stockDetails);	
		}
			
		model.addAttribute("stockResult", stockService.findAll());
		model.addAttribute("stockDetails", new StockDetails());
		return "stockData";
		}
	}*/
	
	/*@PostMapping("/deleteById")
	public String deleteItemById(Model model, StockDetails stockDetails) {
		System.out.println("data id "+stockDetails.getItemId());
		stockService.deleteById(stockDetails.getItemId());
		
		model.addAttribute("stockResult", stockService.findAll());
		model.addAttribute("stockDetails", new StockDetails());
		
		return "stockData";
	}*/
	
	/*
	@RequestMapping(path = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(Model model, StockDetails stockDetails) {
		
		System.out.println("IN Delete "+ stockDetails);
		stockService.delete(stockDetails);
		
		model.addAttribute("stockResult", stockService.findAll());
		model.addAttribute("stockDetails", new StockDetails());
		
		return "stockData";
	}
	*/
	
	

	/*
	 * @RequestMapping(path = "/userRegister", method = RequestMethod.GET) public
	 * String userRegisterScreen(Model model) { model.addAttribute("userDetails",
	 * new UserDetails()); model.addAttribute("userResult", userService.findAll());
	 * 
	 * return "registerUser"; }
	 * 
	 * @RequestMapping(path = "/saveUserRegister", method = RequestMethod.POST)
	 * public String saveUserRegisterScreen(Model model, UserDetails userDetails) {
	 * userDetails.setUserStatus(true);
	 * 
	 * model.addAttribute(userService.save(userDetails));
	 * 
	 * model.addAttribute("userDetails", new UserDetails());
	 * model.addAttribute("userResult", userService.findAll());
	 * 
	 * 
	 * return "registerUser"; }
	 * 
	 * 
	 * @RequestMapping(path = "/deleteUser", method = RequestMethod.POST) public
	 * String deleteUserDetails(Model model, @ModelAttribute(value = "delUserId")
	 * UserDetails usrDts) {
	 * 
	 * 
	 * userService.deleteById(usrDts.getUserId());
	 * 
	 * model.addAttribute("userDetails", new UserDetails());
	 * model.addAttribute("userResult", userService.findAll());
	 * 
	 * 
	 * return "registerUser"; }
	 */

}
