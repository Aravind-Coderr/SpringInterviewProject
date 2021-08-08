package com.EmployeeManageMentSystem.spring.Beans;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="employee")
public class EmployeeDetails {
	@Column(name="first_name")
	private String first_name;
	
	
	@Column(name="last_name")
	private String last_name;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="count")
	private int count;
    
	@Column(name="logindate")
	private LocalDate logindate;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDate getLogindate() {
		return logindate;
	}

	public void setLogindate(LocalDate logindate) {
		this.logindate = logindate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
	@Column(name="username")
	private String username;
	


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
