package com.v2Technologies.project_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.Repository.DesignationRepository;
import com.v2Technologies.project_management_system.entity.Designation;

@Service
public class DestinationServiceImpl implements DestinationService 
{

	@Autowired
	private DesignationRepository destinationrepo;
	
	@Override
	public Designation findByDesignation(String designation) {
		// TODO Auto-generated method stub
		return destinationrepo.findByDesignation(designation);
	}

	@Override
	public List<Designation> findAll() {
		// TODO Auto-generated method stub
		return destinationrepo.findAll();
	}

}
