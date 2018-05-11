package com.v2Technologies.project_management_system.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.v2Technologies.project_management_system.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,java.lang.Long>
{
	List<Project> findByProjectName(String projectName);
	public List<Project> findAllByOrderByPriorityAsc();
	public List<Project> findAllByOrderByProjectStartDateAsc();
	public List<Project> findAllByOrderByProjectEndDateAsc();
	//public Project findByProjectName(String projectName);

}
