package com.v2Technologies.project_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;
import com.v2Technologies.project_management_system.entity.Task;

@Service
public class EmailSendService 
{
	@Autowired
	private MailMail mailMail;
	
	public void mailSendwhenUserAdd(Employee employee)
	{
		
		String from="pratik.gholap@thev2technologies.com";
		String subject="Welcome to "+employee.getCompany().getCompanyName();
		String msg="Your Username is: "+employee.getEmailId()+"\nYour password is: "+employee.getPassword();
		mailMail.sendMail(from,employee.getEmailId(), subject, msg);
		System.out.println("success");
	}
	
	public void mailSendWhenTaskAdd(Task task)
	{
		String from="pratik.gholap@thev2technologies.com";
		String subject="You Are assign for:-"+task.getTaskName()+"Of the Project:-"+task.getAssignProject().getProjectName();
		String msg="Date for completion of Task:-"+task.getTaskEndDate();
		mailMail.sendMail(from,task.getEmployee().getEmailId(), subject, msg);
		System.out.println("Success");
	}
}
