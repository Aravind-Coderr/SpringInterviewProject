package com.EmployeeManageMentSystem.spring.DAO;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManageMentSystem.spring.Beans.SingleLoginDetails;
@Repository
public interface SingleLoginDAO extends JpaRepository<SingleLoginDetails, Integer> {
	
	
	@Query( value = "select id,username,logindate,max(count) as count from singlelogindetails where username=?1 group by logindate order by logindate",nativeQuery=true)
	List<SingleLoginDetails> findByUsername(String name);
	
	@Transactional
	@Modifying
	@Query( value = "update LoginRecords  set  count =?1 where  logindate=?2",nativeQuery=true)
	public int updateCountofSingleDao(int count,String d);
	
	

}
 