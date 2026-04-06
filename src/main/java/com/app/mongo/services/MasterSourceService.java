package com.app.mongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.mongo.dao.MasterSourceDao;
import com.app.mongo.entity.MasterSource;

@Service
public class MasterSourceService {
	
	public List<MasterSource> getMasterSource(){
		List<MasterSource> msList = new ArrayList<>();
		msList.add(new MasterSource(1, "BOA-CC", "A"));
		msList.add(new MasterSource(2, "BOA-CA", "A"));
		msList.add(new MasterSource(3, "CITI-CC", "A"));
		msList.add(new MasterSource(4, "Chase-CC", "A"));		
		
		return msList;
	}

	@Autowired
	private MasterSourceDao masterSourceDao;

	
	public Page<MasterSource> findAll() {
		
		

		return masterSourceDao.findAll();
	}
	
	/*public Iterable<MasterSource> findBySourceName(String name) {
		return masterSourceDao.findBySourceName(name);
	}
  
	public Optional<MasterSource> findById(Integer id) {
		return masterSourceDao.findById(id);
	}

	public MasterSource save(MasterSource masterSource) {
		return masterSourceDao.save(masterSource);
	}

	public MasterSource update(MasterSource masterSource) {
		return masterSourceDao.save(masterSource);
	}

	public void delete(MasterSource masterSource) {
		masterSourceDao.delete(masterSource);
	}

	public void deleteById(Integer id) {
		masterSourceDao.deleteById(id);
	}
	
	public List<MasterSource> getActiveSource(){
		return masterSourceDao.getActiveSourceItems();
	}*/

}
