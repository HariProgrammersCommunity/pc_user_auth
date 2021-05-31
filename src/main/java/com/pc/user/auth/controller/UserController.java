package com.pc.user.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pc.user.auth.model.User;
import com.pc.user.auth.service.UserService;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController	
@RequestMapping("/pc/api")
public class UserController {	
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/users")		
	public @ResponseBody List<User> getAllUsers() throws Exception
	{	
		return userservice.getAll_Service();	
	}
	
	@GetMapping("/getUser/{email}")
	public @ResponseBody User getUserByEmail(@PathVariable("email") String email) throws Exception
	{
				return userservice.getUserByEmail_Service(email);
	}

	@GetMapping("/deleteUser/{email}")
	public ResponseEntity<?> deleteByEmail(@PathVariable("email") String email) throws Exception{
		return userservice.deleteUserByEmail(email);
		
	}
	
	
	
	
}
