package com.EmployeeManageMentSystem.spring;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.EmployeeManageMentSystem.spring.Beans.DateStatistics;
import com.EmployeeManageMentSystem.spring.Beans.EmployeeDetails;
import com.EmployeeManageMentSystem.spring.Beans.LoginStatus;
import com.EmployeeManageMentSystem.spring.Beans.SingleLoginDetails;
import com.EmployeeManageMentSystem.spring.DAO.DateStatisticsDAO;
import com.EmployeeManageMentSystem.spring.DAO.EmployeeLoginDAO;
import com.EmployeeManageMentSystem.spring.DAO.EmployeeServiceDAO;
import com.EmployeeManageMentSystem.spring.DAO.SingleLoginDAO;
import com.EmployeeManageMentSystem.spring.Service.EmployeeService;

@SpringBootApplication
@RestController
public class ManageMentSystemApplication {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/****").allowedOrigins("*").allowedMethods("GET").allowedHeaders("*");
			}
		};
	}

	
	private static int datecounter=0;
	
	@Autowired
	SingleLoginDAO singleservice;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeServiceDAO edao;
//	
	@Autowired
	DateStatisticsDAO datedao;
	
	@Autowired
	EmployeeLoginDAO logindao;
	
	@Autowired
	LoginStatus loginstatus;
	
	@Autowired
	DateStatistics datestat;
	//routes for all the Api end Points
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public LoginStatus welcomeHome(@RequestParam("empid") String empid,@RequestParam("pass") String pass){
		
		System.out.println("&&&&&&&&&&& "+empid+" "+pass);

		if(logindao.validateUsernameAndPassword(empid,pass)==null){
			loginstatus.setMessage("No Valid Credential");
			return loginstatus;
		}
		 
		if(employeeService.getEmpDetails(empid)==null){
			loginstatus.setMessage("No Valid Credential");
		}
		
		if (employeeService.getEmpDetails(empid).getUsername()!=null){
			loginstatus.setMessage("Welcome");

			LocalDate d=LocalDate.now();
			
			LocalDate d2=LocalDate.of(d.getYear(),d.getMonthValue(),d.getDayOfMonth());
			//System.out.println(employeeService.getEmpDetails(empid).getLogindate().toString().substring(0, 11));
			System.out.println(d2.toString());

			System.out.println("Most Recent Date"+datedao.MostRecentDate());
				
			if(datedao.MostRecentDate()!=null && datedao.MostRecentDate().trim().equals(d2.toString().trim())){
				int countfordate=datedao.MostRecentcount(d2.toString());
				System.out.println("Most Recent count for date "+countfordate);
				datedao.updateCountofDate(countfordate+1,d2.toString());
				
			}
			else{
				datecounter=0;
				datecounter++;
				
				datestat.setCount(datecounter);datestat.setLogindate(d2);
				datedao.save(datestat);
				System.out.println("Not Same Date ");

			}
			if(employeeService.getEmpDetails(empid).getLogindate()!=null && employeeService.getEmpDetails(empid).getLogindate().toString().trim().equals(d2.toString().trim())){
			
				System.out.println("CURRENT COUNT "+(employeeService.getEmpDetails(empid).getCount()+1));
				edao.updateCount(employeeService.getEmpDetails(empid).getCount()+1, empid,d2.toString());
				int x=singleservice.updateCountofSingleDao(employeeService.getEmpDetails(empid).getCount()+1, d2.toString());
				SingleLoginDetails s =new SingleLoginDetails();
				s.setCount(employeeService.getEmpDetails(empid).getCount()+1);
				s.setLogindate(d2);
				s.setUsername(empid);
				singleservice.save(s);
				System.out.println(x);

			}
			else{
				EmployeeDetails temp=employeeService.getEmpDetails(empid);
				EmployeeDetails e=new EmployeeDetails();
				e.setFirst_name(temp.getFirst_name());
				e.setLast_name(temp.getLast_name());
				e.setEmail(temp.getEmail());
				e.setUsername(temp.getUsername());
				e.setLogindate(d2);
				e.setCount(1);
				//edao.updateCount(employeeService.getEmpDetails(empid).getCount()+1, empid,d2.toString());
				edao.save(e);
				
				SingleLoginDetails s =new SingleLoginDetails();
				s.setCount(1);
				s.setLogindate(d2);
				
				singleservice.save(s);
			}
			
			
		}
		return loginstatus;
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("logincount/{empid}")
	public EmployeeDetails homepage(@PathVariable("empid") String empid){
		if(edao.getCount(empid)!=null){
			return edao.getCount(empid);
		}
		return null;
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("loginHistory/{empid}")
	public List<SingleLoginDetails> EmpDetails(@PathVariable("empid") String empid){
		
		
		return singleservice.findByUsername(empid);
		
	}
	

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("dailyHistory")
	public List<DateStatistics> LoginCompleteDetails(){
		
		
		return datedao.FindAllRecords();
		
	}
	
	@GetMapping("allUsers")
	public List<EmployeeDetails> EmployeeCompleteDetails(){
		
		
		return edao.findAll(org.springframework.data.domain.Sort.by("username"));
		
	}
	
	
	



	public static void main(String[] args) {
		SpringApplication.run(ManageMentSystemApplication.class, args);
	}
	
	

}
