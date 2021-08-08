package com.EmployeeManageMentSystem.spring.DAO;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManageMentSystem.spring.Beans.EmployeeDetails;


@Repository
public interface EmployeeServiceDAO extends JpaRepository<EmployeeDetails, String> {
	
	@Query( value = "select * from employee where username =:name",nativeQuery=true)
	public EmployeeDetails getCount(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query( value = "update employee  set  count =?1, logindate=?3 where username=?2",nativeQuery=true)
	public int updateCount(int count,String name,String d);
	

}
