package com.v2Technologies.project_management_system.DTO;

import java.util.Date;

import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;

public class ProjectDTO
{
	private String projectName;
	private Date projectStartDate;
	private Date projectEndDate;
	private String priority;
	private Employee employee;

	
	public ProjectDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProjectDTO(String projectName, Date projectStartDate, Date projectEndDate, String priority,Employee employee) {
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.priority = priority;
		this.employee=employee;
	}



	Project current=new Project();

	public Project getCurrent() {
		return current;
	}

	public void setCurrent(Project current) {
		this.current = current;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Date getProjectStartDate() {
		return projectStartDate;
	}


	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}


	public Date getProjectEndDate() {
		return projectEndDate;
	}


	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}


	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}

