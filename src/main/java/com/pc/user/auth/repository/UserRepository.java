package com.pc.user.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pc.user.auth.model.User;

public interface UserRepository extends MongoRepository<User,String>{
		
	User findByEmail(String email);
	Boolean existsByEmail(String email);
}
