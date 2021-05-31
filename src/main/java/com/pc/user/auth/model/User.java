package com.pc.user.auth.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;
@Document(collection = "userInfo")
public class User {

	@Id
	private String id;
	
	@NotBlank
	@Size(max = 20)
	private String firstName;
	
	@NotBlank
	@Size(max = 20)
	private String lastName;
	
	@NotBlank
	@Size(max = 20)
	private String mobileNumber;
	
	@NotBlank
	@Size(max = 100)
	@Email
	private String email;
	
	@NotBlank 
	@Size(max = 100)
	private String password;
	
	
	private String profilePic;
	
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	private String accountCreatedDateandTime = new Date(0).toLocaleString();
	
	public String getAccountCreatedDateandTime() {
		return accountCreatedDateandTime;
	}

	public void setAccountCreatedDateandTime(String accountCreatedDateandTime) {
		this.accountCreatedDateandTime = accountCreatedDateandTime;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	private boolean isActivated;	
	public User() {
		super();	
	}
	public User( @NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
			@NotBlank @Size(max = 20) String mobileNumber, @NotBlank @Size(max = 100) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
