package com.pc.user.auth.payload.response;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String id;
	private String email;
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtResponse(String token,String id, String email) {
		super();
		this.token = token;
		this.id = id;
		this.email = email;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
		
	
}
