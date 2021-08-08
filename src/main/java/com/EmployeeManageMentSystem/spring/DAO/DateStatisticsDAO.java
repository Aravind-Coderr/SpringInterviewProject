package com.EmployeeManageMentSystem.spring.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EmployeeManageMentSystem.spring.Beans.DateStatistics;

@Repository
public interface DateStatisticsDAO extends JpaRepository<DateStatistics,Integer>{
	
	@Transactional
	@Modifying
	@Query( value = "update LoginRecords  set  count =?1 where logindate=?2",nativeQuery=true)
	public int updateCountofDate(int count,String date);
	
	@Transactional  
	@Modifying
	@Query( value = "insert into LoginRecords (count,logindate) values( count =:count, logindate=:logindate )",nativeQuery=true)
	public int insertCountofDate(@Param("count")int count,@Param("logindate") String d);
	
	@Transactional  
	@Query ( value = "select logindate from LoginRecords  order by logindate desc limit 1 ",nativeQuery=true)
	public String MostRecentDate();

	@Transactional  
	@Query ( value = "select count from LoginRecords  where logindate=?1  order by logindate desc limit 1",nativeQuery=true)
	public int MostRecentcount(String date);
	
	@Query ( value="select * from LoginRecords  order by logindate ",nativeQuery=true)
	public List<DateStatistics> FindAllRecords();
	
	
}
