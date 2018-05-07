package com.v2Technologies.project_management_system.Service;

import java.util.List;

import org.apache.tomcat.jni.Library;

import com.v2Technologies.project_management_system.entity.Designation;

public interface DestinationService 
{
	public Designation findByDesignation(String designation);
	public List<Designation> findAll();
}
