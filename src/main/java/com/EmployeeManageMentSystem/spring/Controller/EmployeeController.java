//package com.EmployeeManageMentSystem.spring.Controller;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.EmployeeManageMentSystem.spring.Beans.EmployeeDetails;
//import com.EmployeeManageMentSystem.spring.DAO.DateStatisticsDAO;
//import com.EmployeeManageMentSystem.spring.DAO.EmployeeServiceDAO;
//import com.EmployeeManageMentSystem.spring.Service.EmployeeService;
//
//@SpringBootApplication
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
////public class EmployeeController {
////	
////	private static int datecounter=0;
////	
////	@Autowired
////	EmployeeService employeeService;
////	
////	@Autowired
////	EmployeeServiceDAO edao;
//////	
////	@Autowired
////	DateStatisticsDAO datedao;
////	//routes for all the Api end Points
////	@CrossOrigin(origins = "http://localhost:3000")
////	@GetMapping("/")
////	public String welcomeHome(@RequestParam("empid") String empid){
////		if(employeeService.getEmpDetails(empid)==null){
////			throw new ArithmeticException("Name not Found");
////		}
////		
////		System.out.println("&&&&&&&&&&& "+empid);
////		if (employeeService.getEmpDetails(empid).getUsername()!=null){
////			LocalDate d=LocalDate.now();
////			
////			LocalDate d2=LocalDate.of(d.getYear(),d.getMonthValue(),d.getDayOfMonth());
////			//System.out.println(employeeService.getEmpDetails(empid).getLogindate().toString().substring(0, 11));
////			System.out.println(d2.toString());
////
////			System.out.println("Most Recent Date"+datedao.MostRecentDate());
////				
////			if(datedao.MostRecentDate()!=null && datedao.MostRecentDate().trim().equals(d2.toString().trim())){
////				datecounter++;
////				datedao.updateCountofDate(datecounter,d2.toString());
////				
////			}
////			else{
////				datecounter=0;
////				datecounter++;
////				
////				int x=datedao.insertCountofDate(datecounter, d2.toString());
////				System.out.println("Not Same Date " + x);
////
////			}
////			
////			edao.updateCount(employeeService.getEmpDetails(empid).getCount()+1, empid,d2.toString());
////			return "success";
////			
////		}
////		return "failure";
////		
////	}
////	
////	
////	
////	@GetMapping("logincount/{empid}")
////	public String homepage(@PathVariable("empid") String empid){
////		if(edao.getCount(empid)!=null){
////			return edao.getCount(empid);
////		}
////		
////		return "0";
////	}
////	
////	@GetMapping("loginHistory/{empid}")
////	public EmployeeDetails EmpDetails(@PathVariable("empid") String empid){
////		if(employeeService.getEmpDetails(empid)==null){
////			throw new ArithmeticException("Name not Found");
////		}
////		
////		return employeeService.getEmpDetails(empid);
////		
////	}
////	
////	
////
//}
