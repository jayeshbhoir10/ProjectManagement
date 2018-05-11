package com.v2Technologies.project_management_system.Controller;

import org.springframework.stereotype.Controller;


public class EmailSend 
{
	
	String subject;
	String message;
	String from;
	String to;
	String bcc;
	String cc;
	
	public EmailSend() {
		// TODO Auto-generated constructor stub
	}

	public EmailSend(String subject, String message, String from, String to, String bcc, String cc) {
		super();
		this.subject = subject;
		this.message = message;
		this.from = from;
		this.to = to;
		this.bcc = bcc;
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
	
	
}
