package com.v2Technologies.project_management_system.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.Repository.ProjectRepository;
import com.v2Technologies.project_management_system.entity.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public void addproject(Project project)
	{
		projectRepo.save(project);
	}

	/*@Override
	public List<Project> findByProjectName(String projectName) {
		// TODO Auto-generated method stub
		return projectRepo.findByProjectName(projectName);
	}*/

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepo.findAll();
	}

	@Override
	public List<Project> findAllByOrderByPriorityAsc() {
		// TODO Auto-generated method stub
		return projectRepo.findAllByOrderByPriorityAsc();
	}

	@Override
	public List<Project> findAllByOrderByProjectStartDateAsc() {
		// TODO Auto-generated method stub
		return projectRepo.findAllByOrderByProjectStartDateAsc();
	}

	@Override
	public List<Project> findAllByOrderByProjectEndDateAsc() {
		// TODO Auto-generated method stub
		return projectRepo.findAllByOrderByProjectEndDateAsc();
	}
	
	@Override
	public Optional<Project> findById(long projectId)
	{
		return projectRepo.findById(projectId);
	}
	
	@Override
	public void save(Project project) {
		// TODO Auto-generated method stub
		projectRepo.save(project);
	}

	@Override
	public Project findByProjectName(String projectName) {
		// TODO Auto-generated method stub
		return projectRepo.findByProjectName(projectName);
	}
	

}
