package com.v2Technologies.project_management_system.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.entity.Employee;
import com.v2Technologies.project_management_system.entity.Project;

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
	
	/*public void mailSendWhenProjectAdd(Project project)
	{
		
	}*/
}
