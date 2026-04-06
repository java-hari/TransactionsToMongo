package com.app.mongo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.app.mongo.entity.MasterSource;
import com.app.mongo.repo.MasterSourceRepo;

@Repository
public class MasterSourceDao {

	@Autowired
	private MasterSourceRepo masterSourceRepo;

/*	public Iterable<MasterSource> findBySourceName(String name) {
		return masterSourceRepo.findByName(name);
	}

	public Optional<MasterSource> findById(Integer id) {
		return masterSourceRepo.findById(id);
	}*/

	public Page<MasterSource> findAll() {
		Pageable pageable = PageRequest.of(0, 25);
		return masterSourceRepo.findAll(pageable);
	}

	/*public MasterSource save(MasterSource masterSource) {
		return masterSourceRepo.save(masterSource);
	}

	public MasterSource update(MasterSource masterSource) {
		return masterSourceRepo.save(masterSource);
	}

	public void delete(MasterSource masterSource) {
		masterSourceRepo.delete(masterSource);
	}

	public void deleteById(Integer id) {
		masterSourceRepo.deleteById(id);
	}

	public List<MasterSource> getActiveSourceItems(){
		return masterSourceRepo.getActiveSourceItems();
	}*/

}
