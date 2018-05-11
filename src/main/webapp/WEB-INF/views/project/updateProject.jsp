<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h3><center>UPDATE PROJECT</center></h3>
		
		<spring:url value="/project/editproject" var="projectAddUrl" />
		<form:form modelAttribute="project" action="${ projectAddUrl }">
		
		<table border="1" align="center" cellpadding="5" cellspacing="5">
			<tr>
				<td>Project Name</td>
				<td><form:input type="text" path="projectName" id="projectname" /><br />
				</td>
			</tr>
			<%-- <form:checkbox path="checkDate" /> --%>
			<tr>
				<td>Start Date</td>
				<td><form:input type="date" id="startDate" path="projectStartDate" placeholder="YYYY-MM-DD" onblur="addProject()" />
				 <span id="sdate" style="color: red"></span>
				</td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><form:input type="date"  id="endDate" path="projectEndDate" placeholder="YYYY-MM-DD" onblur="addProject()" />
				<span id="edate" style="color: red" ></td>
			</tr>
			<tr>
				<td>Priority</td>
				<td><form:input type="range" path="priority" maxlength="100" /><br /></td>
			</tr>
			<tr>
				<td>Manager</td>
				<td><input type="text" name="employee" value="${ sessionScope.employee.userName }" readonly="readonly" > <span id="merror" style="color: red"></span><br />
				</td>
			</tr>
			<tr><td></td>
				<td><input type="hidden" name="projectId" value="${ proj.projectId }"> 
				<input type="submit" value="ADD"> <input type="reset" value="RESET"></td>
			</tr>
			
			</table>

		</form:form>


</body>
</html>