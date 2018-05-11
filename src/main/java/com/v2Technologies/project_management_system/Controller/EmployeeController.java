package com.v2Technologies.project_management_system.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.DesignationRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.Service.EmailSendService;
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
	DesignationRepository desiRepo;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeerepo; 
	
	@Autowired
	EmailSendService emailSendService;
		
	
	@PostMapping("/search")
	public String searchByName(@RequestParam("searchName") String Name,Model m)
	{
		List<Employee> li = employeeService.findByEmployeeName(Name);
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	
	@RequestMapping(value="/sortonname",method=RequestMethod.GET)
	public String sortByName(Model m)
	{

		List<Employee> uListOntname=(List<Employee>) employeeService.findAll();
	
		System.out.println(uListOntname);
		m.addAttribute("employees",uListOntname);
		return "employee/allEmployee";
	}
	
	@PostMapping("/showEditEmployee")
	public String showEditEmployee(@RequestParam("uId") long eId, Model m) {
		
		
		Employee e=new Employee();
		List<Designation> li=desiRepo.findAll();
		List<String> desi=new ArrayList<>();
		for(Designation d:li)
		{
			desi.add(d.getDesignation());
		}
		m.addAttribute("emp", e);
		m.addAttribute("designations", desi);
		
		Optional<Employee> u = employeeService.findById(eId);
		Employee emp = u.get();
		System.out.println("=====================================");
		System.out.println(emp);
		System.out.println("=====================================");
		m.addAttribute("emp", emp);

		return "employee/updateEmployee";
	}
	
	//edit&save
	@RequestMapping(value="/editEmployee",method=RequestMethod.POST)
	@Transactional
	public String editUser(@ModelAttribute("emp") Employee employee, BindingResult bindingResult, Model m) {
		
		Employee emp = employee;
		emp.setEmployeeId(employeeService.findById(employeeService.findByEmailId(emp.getEmailId()).getEmployeeId()).get().getEmployeeId());
		System.out.println(emp.getEmployeeId());
		Company c = companyrepo.findByCompanyName(emp.getCompany().getCompanyName());
		emp.setCompany(c);
		
		Designation d = desiRepo.findByDesignation(employee.getDesignation().getDesignation());
		emp.setDesignation(d);
		m.addAttribute("emp", emp);
		employeeService.addEmployee(employee);
		List<Employee> li = (List<Employee>) employeeService.findAll();
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}
	
	
	
/*	@RequestMapping(value="/showEditEmployee",method=RequestMethod.POST,params={"action=delete"})
	public String deleteEmployee(@RequestParam("uId") long employeeId, Model m)
	{
		System.out.println("IN delete User " + employeeService);
		employeerepo.deleteById(employeeId); 
		List<Employee> li = (List<Employee>) employeeService.findAll();
		m.addAttribute("employees", li);
		return "employee/allEmployee";
	}*/
	
	@RequestMapping(value="/showEditEmployee",method=RequestMethod.POST,params={"action=delete"})
	public String deleteUser(@ModelAttribute("emp")Employee user,Model m,HttpServletRequest request)
	{

		System.out.println(user+"---------------------------");
		employeerepo.delete(user);
		request.getSession().setAttribute("emp",user);
		return "redirect:/user/users";
	}
	
	
	
	
	/*
	
	//edit&save
		@PostMapping("/editUser")
		public String editUser(@ModelAttribute("use") User use, BindingResult bindingResult, Model m) {
			User u = use;
			m.addAttribute("checkDate", true);
			m.addAttribute("use", u);
			userrepo.save(u);
			List<User> li = (List<User>) userrepo.findAll();
			m.addAttribute("users", li);
			return "user/allUser";
		}


	//delete
	@RequestMapping(value="showEditUser",method=RequestMethod.POST,params={"action=delete"})
	public String deleteUser(@RequestParam("uId") long uId, Model m)
	{
		System.out.println("IN delete User " + uId);
		userrepo.deleteById(uId); 
		List<User> li = (List<User>) userrepo.findAll();
		m.addAttribute("users", li);
		return "user/allUser";
	}
*/
	
	
	
	
	
	
	
	@GetMapping("/employees")
	public String showAllEmployee(Model m)
	{
		Iterable<Employee> li = employeeService.findAll();

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
	
	 
	@GetMapping("/viewEmployeePage")
	public String showAddUser(Model m,HttpSession s)
	{
		Employee e=new Employee();
		List<Designation> li=desiRepo.findAll();
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
	public String SaveUser(@ModelAttribute("emp")@Valid Employee employee,BindingResult bindingResult,Model m,HttpServletRequest request,@RequestParam(name="company.companyName") String cName)
	{
	
		//employee.setCompany(company);
		System.out.println(employee);	 
		System.out.println(cName);
		Company c=employee.getCompany();
		Designation d = employee.getDesignation();

		System.out.println(c+"--------"+d);
		d.setDesignationId(desiRepo.findByDesignation(employee.getDesignation().getDesignation()).getDesignationId());
		c.setCompanyId(companyrepo.findByCompanyName(employee.getCompany().getCompanyName()).getCompanyId());
		
		employeeService.addEmployee(employee);
		emailSendService.mailSendwhenUserAdd(employee);
		m.addAttribute("emp",employee);
		request.getSession().setAttribute("emp",employee);
		return "redirect:/employee/allEmployee";
		
	}
	
	@GetMapping("/allEmployee")
	public String viewAllEmployee(Model model,HttpServletRequest request)
	{
		Iterable<Employee> li = employeeService.findAll();
		model.addAttribute("employees", li);
		request.getSession().setAttribute("emp",li);
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
