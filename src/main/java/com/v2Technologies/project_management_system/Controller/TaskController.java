package com.v2Technologies.project_management_system.Controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.v2Technologies.project_management_system.Service.EmailSendService;
import com.v2Technologies.project_management_system.Service.EmployeeService;
import com.v2Technologies.project_management_system.Service.ProjectService;
import com.v2Technologies.project_management_system.Service.TaskService;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

@Controller
@RequestMapping("/task")
public class TaskController 
{
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	EmailSendService emailSendService;
	
	@GetMapping("/viewTask")
	public String viewTaskPage(Model model)
	{
		Task task=new Task();
		List<Project> projects=projectService.findAll();
		List<String> projectNames= new ArrayList<>();
		
		for (Project project : projects)
		{
			projectNames.add(project.getProjectName());
		}
		
		System.out.println(projectNames+"0000000");
		
		List<Employee>  employees=employeeService.findAll();
		List<String> employeeIds=new ArrayList<>();
		
		for (Employee employee: employees) {
			employeeIds.add(employee.getEmailId());
		}
		
		System.out.println(employeeIds+"1111111");
	
		model.addAttribute("projectNames",projectNames);
		model.addAttribute("employeeIds",employeeIds);
		model.addAttribute("task",task);	
		return "task/addTask";
	}
	
	@PostMapping("/addTask")
	public String addTask(@ModelAttribute("task") Task task,BindingResult bindingResult,Model model,HttpServletRequest request)
	{
		
		Project p = projectService.findByProjectName(task.getAssignProject().getProjectName());
		task.setAssignProject(p);
		
		Employee employee=employeeService.findByEmailId(task.getEmployee().getEmailId());
		task.setEmployee(employee);
		
		
		String taskStartDate=request.getParameter("taskStartDate");
		if(taskStartDate==null)
		{
			taskStartDate=convertDateToString(task.getTaskStartDate());
		}
		task.setTaskStartDate(convertDate(taskStartDate));
		
		String taskEndDate=request.getParameter("taskEndDate");
		if(taskEndDate==null)
		{
			taskEndDate=convertDateToString(task.getTaskEndDate());
		}
		task.setTaskEndDate(convertDate(taskEndDate));
		
		System.out.println(taskEndDate+"--"+taskStartDate);
		
		System.out.println(task);
		taskService.addTask(task);
		emailSendService.mailSendWhenTaskAdd(task);
		model.addAttribute("task",task);
		return "redirect:/task/viewAllTask";
	}
	
	@GetMapping("/viewAllTask")
	public String viewAllTask(Model model)
	{
		Iterable<Task> tIterable=taskService.findAll();
		model.addAttribute("tasks",tIterable);
		return "task/allTask";
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
