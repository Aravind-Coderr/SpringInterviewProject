package com.EmployeeManageMentSystem.spring.Beans;

import org.springframework.stereotype.Component;

@Component
public class LoginStatus {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
