package com.EmployeeManageMentSystem.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EmployeeManageMentSystem.spring.Beans.Employee;

@Repository
public interface EmployeeLoginDAO extends JpaRepository<Employee, String>{
		
	@Query(value="select * from users u where u.username=?1 and u.password=?2",nativeQuery=true)
	Employee validateUsernameAndPassword(String username, String password);

}
 