package com.v2Technologies.project_management_system.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.v2Technologies.project_management_system.Repository.CompanyRepository;
import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.Repository.GeneralAdminRepository;
import com.v2Technologies.project_management_system.Service.DesignationService;
import com.v2Technologies.project_management_system.Service.EmployeeService;
import com.v2Technologies.project_management_system.Service.GeneralAdminService;
import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Designation;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.GeneralAdmin;



@Controller
@RequestMapping("/company")
@SessionAttributes("company")
public class GeneralAdminController {
	
	
	@Autowired
	GeneralAdminService gar;
	
	@Autowired
	CompanyRepository crepo;
	
	@Autowired
	EmployeeService employeeService; 
	
	@Autowired
	DesignationService designationService;
	
	@Autowired
	EmployeeRepository erepo;
	
	@GetMapping("/add")
	public String showAddProject(Model m)
	{
		System.out.println("hello");
		Employee employee=new Employee();
		
		/*Company company=new Company();
		Designation designation=new Designation();*/
		List<Company> li=crepo.findAll();
		List<String> companyNames=new ArrayList<>();
		
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		
		System.out.println(companyNames);
		
		List<Designation> designations=designationService.findAll();
		List<String> designationNames=new ArrayList<>();
		
		for (Designation d : designations) 
		{
			designationNames.add(d.getDesignation());
		}
		
		System.out.println(designationNames);
		m.addAttribute("employee", employee);
		m.addAttribute("designations", designationNames);
		m.addAttribute("companyNames", companyNames);
	
		return "Home/home";
	}
	
	

	@GetMapping("/generalAdminLogin")
	public String showLoginPage(Model m) {
	
		
		Company company=new Company();
		m.addAttribute("company", company);
		System.out.println("hiiiiiiiiiiiiiii");
		return "company/GeneralAdminLogin";
	}
	
	

	
	@PostMapping("/addAdminCompany")
	public String checkAdminCredentials(@ModelAttribute GeneralAdmin generalAdmin,Company company, Model m)
	{
		GeneralAdmin general=gar.findByAdminNameAndPassword(generalAdmin.getAdminName(), generalAdmin.getPassword());
		System.out.println(generalAdmin.getAdminName()+""+generalAdmin.getPassword());
		if(general!=null)
		{
			System.out.println(general+"---"+"++");
			Company c=new Company();
			m.addAttribute("company", c);
			return "company/AddAdmin&Company";
		}
		else
		{
			return "company/GeneralAdminLogin";
		}
	}
	
	@PostMapping("/saveAdminCompany")
	public String saveCompanyAdminPassword(@ModelAttribute("company") Company company,Model m)
	{
		crepo.save(company);
		System.out.println("hellooooooo");
		return "company/AddAdmin&Company";
	}
	
	@GetMapping("/companyAdminLogin")
	String companyAdminLoginForm(Model m)
	{
		Company company=new Company();
		List<Company> li=crepo.findAll();
		List<String> companyNames=new ArrayList<>();
		for(Company c:li)
		{
			companyNames.add(c.getCompanyName());
		}
		m.addAttribute("company", company);
		m.addAttribute("companyNames", companyNames);
		return "company/companyAdminLogin";
	}
	
	/*@PostMapping("/loginAdminCompany")
	String loginCompanyAdmin(@ModelAttribute("company")GeneralAdmin admin, Company company,Model m)
	{
		System.out.println("HHHHHHHHHH");
		Company company2=crepo.findByAdminNameAndPasswordAndCompanyName(company.getAdminName(),company.getPassword(),company.getCompanyName());
		if(company2!=null)
		{
			return "Home/adminMenu";
		}
		else
		{
			return "redirect:/company/companyAdminLogin";
		}
		
	}*/
	
	@PostMapping("/loginAdminCompany")
	public String loginCompanyAdmin( @ModelAttribute("company") Company company,Model m )
	{
	    Company  c = crepo.findByAdminNameAndPasswordAndCompanyName(company.getAdminName(),company.getPassword(),company.getCompanyName());
	    
	    if(c!=null )
	    	return "Home/adminMenu";
	    
	    return "redirect:/company/companyAdminLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession s)
	{
		s.invalidate();
		return "company/GeneralAdminLogin";
	}

	
	
}
