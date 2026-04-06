package com.app.mongo.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.mongo.entity.MasterSource;

public interface MasterSourceRepo extends PagingAndSortingRepository<MasterSource, Integer> {

	//public Iterable<MasterSource> findByName(String name);
	
	//@Query("SELECT t FROM MasterSource t where t.status='A'")
	//public List<MasterSource> getActiveSourceItems();
	

}
