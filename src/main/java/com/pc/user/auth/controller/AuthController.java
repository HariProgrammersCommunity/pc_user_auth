package com.pc.user.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.user.auth.model.User;
import com.pc.user.auth.payload.request.LoginRequest;
import com.pc.user.auth.payload.request.SignupRequest;
import com.pc.user.auth.payload.response.JwtResponse;
import com.pc.user.auth.payload.response.MessageResponse;
import com.pc.user.auth.repository.UserRepository;
import com.pc.user.auth.security.jwt.JwtUtils;
import com.pc.user.auth.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController	
@RequestMapping("/pc/auth")
public class AuthController {	

	@Autowired	
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;	
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));	
//		SecurityContextHolder.getContext().setAuthentication(authentication);	
		String jwt = jwtUtils.generateJwtToken(authentication);	
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println("UserDetails"+userDetails);
		return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getEmail()));
	}
	//sign up form
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getFirstName(),
							 signUpRequest.getLastName(),
							 signUpRequest.getMobileNumber(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
