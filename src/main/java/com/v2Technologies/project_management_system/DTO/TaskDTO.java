package com.v2Technologies.project_management_system.DTO;

import java.util.Date;

import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

public class TaskDTO
{
	private String taskName;
	private Date taskStartDate;
	private Date taskEndDate;
	private String priority;
	private boolean status;
	private Project project;
	private Employee employee;
	
	public TaskDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskDTO(String taskName, Date taskStartDate, Date taskEndDate, String priority, boolean status,
			Project project,Employee employee) {
		super();
		this.taskName = taskName;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.priority = priority;
		this.status = status;
		this.project = project;
		this.employee=employee;
	}

	Task currenttask=new Task();
	
	public Task getCurrenttask() {
		return currenttask;
	}

	public void setCurrenttask(Task currenttask) {
		this.currenttask = currenttask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	
	
	
	
}
