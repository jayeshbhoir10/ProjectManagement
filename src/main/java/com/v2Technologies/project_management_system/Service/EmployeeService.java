package com.v2Technologies.project_management_system.Service;

import java.util.List;

import javax.validation.Valid;

import com.v2Technologies.project_management_system.entity.Employee;

public interface EmployeeService
{
	public void addEmployee(Employee employee);
	public List<Employee> findAll();
}
