package com.v2Technologies.project_management_system.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.Repository.TaskRepository;
import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService 
{
	@Autowired
	private TaskRepository taskrepository;
	@Autowired
	ProjectService projectService;

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		
		
	
		taskrepository.save(task);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskrepository.findAll();
	}

}
