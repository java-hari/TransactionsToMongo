package com.app.mongo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.app.mongo.entity.StockDetails;
import com.app.mongo.repo.StockRepo;

@Repository
public class StockDao {

	@Autowired
	private StockRepo stockRepo;

	public Iterable<StockDetails> findByItemName(String name) {
		return stockRepo.findByItemName(name);

	}
	public Page<StockDetails> findAll() {
		Pageable pageable = PageRequest.of(0, 5);
		return stockRepo.findAll(pageable);
	}
	
	/*public Optional<StockDetails> findById(Integer id) {
		return stockRepo.findById(id);
	}

	public StockDetails save(StockDetails stockDetails) {
		return stockRepo.save(stockDetails);
	}

	public StockDetails update(StockDetails stockDetails) {
		return stockRepo.save(stockDetails);
	}

	public void delete(StockDetails stockDetails) {
		stockRepo.delete(stockDetails);
	}

	public void deleteById(Integer id) {
		stockRepo.deleteById(id);
	}*/

}
