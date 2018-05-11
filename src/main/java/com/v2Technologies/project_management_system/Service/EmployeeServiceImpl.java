package com.v2Technologies.project_management_system.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.Repository.EmployeeRepository;
import com.v2Technologies.project_management_system.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeerepo;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeerepo.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
		// TODO Auto-generated method stub
		return employeerepo.findByEmployeeName(employeeName);
	}

	@Override
	public Employee findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return employeerepo.findByEmailId(emailId);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeerepo.findById(id);
	}

	

}
