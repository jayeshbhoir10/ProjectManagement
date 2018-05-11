package com.v2Technologies.project_management_system.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.v2Technologies.project_management_system.entity.Company;
import com.v2Technologies.project_management_system.entity.Designation;
import com.v2Technologies.project_management_system.entity.Employee;

public interface EmployeeService
{
	public void addEmployee(Employee employee);
	public List<Employee> findAll();
	List<Employee> findByEmployeeName(String employeeName);
	Employee findByEmailId(String emailId);
	Optional<Employee> findById(Long id);
	//public void deleteById(Long Id);
	public Employee findByCompanyAndEmailIdAndPasswordAndDesignation(Company company,String emailId,String password,Designation designation);
	
}
