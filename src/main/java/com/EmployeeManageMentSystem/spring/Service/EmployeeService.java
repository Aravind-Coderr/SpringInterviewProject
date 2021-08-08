package com.EmployeeManageMentSystem.spring.Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.EmployeeManageMentSystem.spring.Beans.Employee;
import com.EmployeeManageMentSystem.spring.Beans.EmployeeDetails;

@Component
public interface EmployeeService{
	
	public int getLoginno(String empid);
	
	public EmployeeDetails getEmpDetails(String name);
	

}
