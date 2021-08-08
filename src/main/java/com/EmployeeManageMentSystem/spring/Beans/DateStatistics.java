package com.EmployeeManageMentSystem.spring.Beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="LoginRecords")
public class DateStatistics {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
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

	public DateStatistics() {
	}
	
	

}
