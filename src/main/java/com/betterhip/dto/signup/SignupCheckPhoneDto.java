package com.betterhip.dto.signup;

public class SignupCheckPhoneDto {
	String user_id;
	
	public SignupCheckPhoneDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SignupCheckPhoneDto(String user_id) {
		super();
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
