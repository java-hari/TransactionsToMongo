package com.app.mongo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.mongo.entity.StockDetails;

//public interface StockRepo extends CrudRepository<StockDetails, Integer> {

public interface StockRepo extends PagingAndSortingRepository<StockDetails, Integer> {
	
	public Iterable<StockDetails> findByItemName(String name);
	
		
}
