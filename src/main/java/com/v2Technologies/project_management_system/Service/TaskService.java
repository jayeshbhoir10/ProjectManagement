package com.v2Technologies.project_management_system.Service;

import java.util.List;

import com.v2Technologies.project_management_system.entity.Task;

public interface TaskService 
{
	
	public void addTask(Task task);
	public List<Task> findAll();
}
