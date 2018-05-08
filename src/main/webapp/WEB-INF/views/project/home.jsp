<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="/resources/loginForm/css/style.css">
        <dev1><center><h1><b>Project Manager</b></h1></h1></center></dev1>
			<center>
				<c:if test="${ employee.designation eq 'ADMINISTRATOR' }">
				 <span style="padding-left:20px"><a href="/user/add"><b>Add User</b></a></span>
				<span style="padding-left:20px"><a href="/task/viewTask"><b>View Task</b></a></span>
				<span style="padding-left:20px"><a href="/employee/logout" scope="session"><b>Logout</b></a></span>
			</c:if>
			
			<c:if test="${ employee.designation eq 'PROJECT_MANAGER' }">
				<span style="padding-left:20px"><a href="/project/add"><b>Add Project</b></a></span>
				<span style="padding-left:20px"><a href="/task/add"><b>Add Task</b></a> </span>
				<span style="padding-left:20px"><a href="/task/viewTask"><b>View Task</b></a></span>
				<span style="padding-left:20px"><a href="/employee/logout" scope="session"><b>Logout</b></a></span>
			</c:if>

			</center>
</body>
</html>