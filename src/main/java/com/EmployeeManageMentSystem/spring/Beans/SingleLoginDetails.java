package com.EmployeeManageMentSystem.spring.Beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="singlelogindetails")
public class SingleLoginDetails {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	
	@Column(name="count")
	private int  count;
	
	@Column(name="logindate")
	private LocalDate logindate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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
	

}
