package com.app.mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.mongo.dao.StockDao;
import com.app.mongo.entity.StockDetails;

@Service
public class StockService {

	@Autowired
	private StockDao stockDao;

	public Iterable<StockDetails> findByItemName(String name) {
		return stockDao.findByItemName(name);
	}


	public Page<StockDetails> findAll() {

		return stockDao.findAll();
	}

	/*public Optional<StockDetails> findById(Integer id) {
		return stockDao.findById(id);
	}
	public StockDetails save(StockDetails stockDetails) {
		return stockDao.save(stockDetails);
	}

	public StockDetails update(StockDetails stockDetails) {
		return stockDao.save(stockDetails);
	}

	public void delete(StockDetails stockDetails) {
		stockDao.delete(stockDetails);
	}

	public void deleteById(Integer id) {
		stockDao.deleteById(id);
	}*/

}
