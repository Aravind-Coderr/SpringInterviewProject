package com.EmployeeManageMentSystem.spring.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.EmployeeManageMentSystem.spring.Beans.Employee;
import com.EmployeeManageMentSystem.spring.Beans.EmployeeDetails;
import com.EmployeeManageMentSystem.spring.DAO.EmployeeServiceDAO;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	EmployeeServiceDAO employeeDao;


	@Transactional
	public int getLoginno(String empid) {
		return 0;
	}
	
	@Transactional
	public EmployeeDetails getEmpDetails(String name){
		Optional<EmployeeDetails> e=employeeDao.findById(name);
		if(e.isPresent())
		return e.get();
		return null;
	}


	

}
