package com.pc.user.auth.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pc.user.auth.model.User;



public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String firstName;
	
	private String lastName;

	private String mobileNumber;
	
	private String email;
	 
	@JsonIgnore
	private String password;
	
	public UserDetailsImpl(String id, String firstName, String lastName, String mobileNumber,String email,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public static UserDetailsImpl build(User user) {
			return new UserDetailsImpl(
				user.getId(), 
				user.getFirstName(),
				user.getLastName(),
				user.getMobileNumber(),
				user.getEmail(),
				user.getPassword()
				);
	}
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getMobileNumber() {
		// TODO Auto-generated method stub
		return mobileNumber;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
	
	
	
	
	
	
	
	
}
