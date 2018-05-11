package com.v2Technologies.project_management_system.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.v2Technologies.project_management_system.DTO.ProjectDTO;
import com.v2Technologies.project_management_system.Service.EmailSendService;
import com.v2Technologies.project_management_system.Service.ProjectService;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;

@Controller
@RequestMapping("project")
@SessionAttributes("employee")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmailSendService emailSendController;
	
	
	@GetMapping("project")
	public String showProjectScreen(Model m)
	{
		Project p=new Project();
		m.addAttribute("project", p);
		return "project/addProject";
	}
	
	@GetMapping("/projectManagerMenu")
	public String projectManagerMenu( @ModelAttribute("project") Project project,Model m )
	{
	   
	    m.addAttribute("project", project);
	   
	    
	    return "Home/projectManagerMenu";
	}

	@PostMapping("/add")
	public String saveProject(@ModelAttribute ProjectDTO project,BindingResult bindingResult,Model m,HttpServletRequest request)
	{
		Project project2=project.getCurrent();
		
		Employee employee=project2.getEmployee();
		
		//employee.setEmployeeId(projectService.findByProjectName(project2.getEmployee().getEmailId()));
		
		String startDate=request.getParameter("projectStartDate");
		if(startDate==null)
		{
			startDate=convertDateToString(project.getProjectStartDate());
		}
		project.setProjectStartDate(convertDate(startDate));
		project2.setProjectStartDate(project.getProjectStartDate());
	
		String endDate=request.getParameter("projectEndDate");
		if(endDate==null)
		{
			endDate=convertDateToString(project.getProjectEndDate());
		}
		project.setProjectEndDate(convertDate(endDate));
		project2.setProjectEndDate(project.getProjectEndDate());
		
		project2.setProjectName(project.getProjectName());
		project2.setPriority(project.getPriority());
		project2.getEmployee().setEmailId(project.getEmployee().getEmailId());
		
		System.out.println(project2);
		
		projectService.addproject(project2);
		
		//emailSendController.mailSendWhenProjectAdd(project2.getEmployee().getEmailId(), project2);
		
		return "redirect:/project/projects";
	}
	
	@GetMapping("projects")
	public String showAllProjects(Model m)
	{
		Iterable<Project> pl=projectService.findAll();
		m.addAttribute("projects", pl);
		return "project/allProjects";
	}

	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return (List<Project>)projectService.findAll();
	}
	
	@PostMapping("/search")
	public String searchProjectByName(@RequestParam("searchName") String projectName,Model m)
	{
		Project li=projectService.findByProjectName(projectName);
		m.addAttribute("projects", li);
		return "project/allProjects";
	}
	
	@RequestMapping(value="sortOnStartDate", method=RequestMethod.GET)
	public String projectSortOnStartDate(Model m)
	{
		List<Project> projectList=projectService.findAllByOrderByProjectStartDateAsc();
		m.addAttribute("projects",projectList);
		return "project/allProjects";
	}
	
	@RequestMapping(value="sortOnLastDate", method=RequestMethod.GET)
	public String projectSortOnEndDate(Model m)
	{
		List<Project> projectList=projectService.findAllByOrderByProjectEndDateAsc();
		//Collections.sort(projectList,new projectSortOnEndDate());
		m.addAttribute("projects", projectList);
		return "project/allProjects";
	}
	
	@RequestMapping(value="priority" ,method=RequestMethod.GET)
	public String projectSortOnPriority(Model m)
	{
		List<Project> projects=projectService.findAllByOrderByPriorityAsc();
		m.addAttribute("projects",projects);
		return "project/allProjects";
	}
	
	
	@PostMapping("/showEditProject")
	public String showEditProjectPage(@RequestParam("projectId")long projectId,Model m)
	{
		System.out.println("projectID===="+projectId);
		Optional<Project> p=projectService.findById(projectId);
		Project project=p.get();
		m.addAttribute("project", project);
		System.out.println("Project======");
		return "project/updateProject";
	}
	
	@PostMapping("/editproject")
	public String editProject(@ModelAttribute("project") ProjectDTO  proj, BindingResult bindingResult, Model m) {
		Project p = proj.getCurrent();
		//m.addAttribute("checkDate", true);
		m.addAttribute("project", p);
		projectService.save(p);
		List<Project> li = (List<Project>) projectService.findAll();
		m.addAttribute("projects", li);
		return "project/allProjects";
	}
	
	private Date convertDate(String date) {
		try {
			String format = "yyyy-MM-dd";
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	private String convertDateToString(Date date) {
		String format = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
		//opbalRepo.
	}
	

}
