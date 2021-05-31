package com.pc.user.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pc.user.auth.model.User;
import com.pc.user.auth.payload.response.MessageResponse;
import com.pc.user.auth.repository.UserRepository;


@Service
public class UserService{
	
	@Autowired
	UserRepository userRepository;
	//*************************************Get All User**********************************************************
	public List<User> getAll_Service() throws Exception {
		// TODO Auto-generated method stub
		try {
			return userRepository.findAll();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
	}
	//*************************************Get User by Email ****************************************************
	public User getUserByEmail_Service(String email) throws Exception{
		// TODO Auto-generated method stub	
		try {
			if(userRepository.existsByEmail(email)) {	
				return userRepository.findByEmail(email);
			}
			else {	
				throw new UsernameNotFoundException(email);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
			
	}
	//*************************************Delete User by email**************************************************
	public ResponseEntity<?> deleteUserByEmail(String email) throws Exception {
			try {
				if(userRepository.existsByEmail(email))
				{
				userRepository.deleteByEmail(email);
				return ResponseEntity.ok(new MessageResponse("User Deleted Successfully successfully!"));
				}	
				else {
					return ResponseEntity
									.badRequest()
											.body(new MessageResponse("Error Occured"));	
				}
			}
		catch(Exception e) {
			throw new Exception(e);
		}
		
	}

}
