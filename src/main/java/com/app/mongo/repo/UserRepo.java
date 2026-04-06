package com.app.mongo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.mongo.entity.UserDetails;

public interface UserRepo extends MongoRepository<UserDetails, Integer> {
	
	public Optional<UserDetails> findByUserName(String name);
	
//	public void updateByUserStatus(Integer id);
	
}
