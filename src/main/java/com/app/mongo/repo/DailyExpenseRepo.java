package com.app.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.mongo.entity.DailyExpense;


public interface DailyExpenseRepo extends MongoRepository<DailyExpense, Integer> {

	public Iterable<DailyExpense> findByItemName(String itemName);
	public DailyExpense findTopByOrderByIdDesc();
	
	public List<DailyExpense> findTop5ByOrderByIdDesc();
	
	

}
