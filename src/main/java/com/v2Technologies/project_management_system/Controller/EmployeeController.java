package com.v2Technologies.project_management_system.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.DesignationRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.Service.DestinationService;
import com.v2Technologies.project_management_system.Service.EmployeeService;
import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Designation;
import com.v2Technologies.project_management_system.entity.Employee;


@Controller
@RequestMapping("/employee")
@SessionAttributes("company")
public class EmployeeController {
	
	@Autowired
	CompanyRepository companyrepo;
	
	
	@Autowired
	DestinationService destservice;
	
	@Autowired
	EmployeeService empService;
	
	
	
	
	
	@GetMapping("/employees")
	public String showAllEmployee(Model m)
	{
		Iterable<Employee> li = empService.findAll();

		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	

	@GetMapping("/home")
	public String showHome(Model m)
	{
		
		Company company=new Company();
		List<Company> li=companyrepo.findAll();
		List<String> companyNames=new ArrayList<>();
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		m.addAttribute("company", company);
		m.addAttribute("companyNames", companyNames);
		return "Home/home";
	}
	
	 
	@GetMapping("/add")
	public String showAddUser(Model m,HttpSession s)
	{
		Employee e=new Employee();
		List<Designation> li=destservice.findAll();
		List<String> desi=new ArrayList<>();
		for(Designation d:li)
		{
			desi.add(d.getDesignation());
		}
		m.addAttribute("emp", e);
		m.addAttribute("designations", desi);
		return "employee/addEmployee";
	}
	
	@PostMapping("/add")
	public String SaveUser(@ModelAttribute("emp")@Valid Employee employee,BindingResult bindingResult,Model m,HttpServletRequest request)
	{
		System.out.println(employee+"--------++++++++");
		Designation d = employee.getDesignation();
		Company c=employee.getCompany();
		System.out.println(c+"-----cccc---------");
		d.setDesignationId(destservice.findByDesignation(employee.getDesignation().getDesignation()).getDesignationId());
		c.setCompanyId(companyrepo.findByCompanyName(employee.getCompany().getCompanyName()).getCompanyId());
		c.associateEmployee(employee);
		
		
		
		empService.addEmployee(employee);
		System.out.println(employee+"--------");
		Iterable<Employee> li = empService.findAll();
		System.out.println(li);
		m.addAttribute("employee", li);
		return "employee/allEmployee";
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession s,Model m)
	{
		
		Company company=new Company();
		List<Company> li=companyrepo.findAll();
		List<String> companyNames=new ArrayList<>();
		
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		m.addAttribute("company", company);
		m.addAttribute("companyNames", companyNames);
		s.invalidate();
		return "Company/companyAdminLogin";
	}

	
	
	
}
