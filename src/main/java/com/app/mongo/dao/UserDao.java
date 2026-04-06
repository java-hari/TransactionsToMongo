package com.app.mongo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.mongo.entity.UserDetails;
import com.app.mongo.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo userRepo;

	public Optional<UserDetails> findById(Integer id) {
		return userRepo.findById(id);
	}
	
	public Iterable<UserDetails> findAll(){
		return userRepo.findAll();
	}

	public UserDetails save(UserDetails userDetails){
		return userRepo.insert(userDetails);
	}
	
	public UserDetails update(UserDetails userDetails){
		return userRepo.save(userDetails);
	}
	
	public void deleteById(Integer id) {
		userRepo.deleteById(id);
	}
	
	public Optional<UserDetails> findByUserName(String name) {
		return userRepo.findByUserName(name);

	}
	
	
}
