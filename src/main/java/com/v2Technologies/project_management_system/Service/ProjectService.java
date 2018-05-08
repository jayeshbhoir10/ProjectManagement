package com.v2Technologies.project_management_system.Service;

import java.util.List;

import com.v2Technologies.project_management_system.entity.Project;

public interface ProjectService
{
	public void addproject(Project project);
	List<Project> findByProjectName(String projectName);
	List<Project> findAll();
	public List<Project> findAllByOrderByPriorityAsc();
	public List<Project> findAllByOrderByProjectStartDateAsc();
	public List<Project> findAllByOrderByProjectEndDateAsc();
}
