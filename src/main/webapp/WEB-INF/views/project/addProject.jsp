<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddProject</title>
</head>
<body>
<spring:url value="/project/add" var="projectAddUrl" />
		<form:form modelAttribute="project" action="${ projectAddUrl }"  onSubmit="return addProject()">
		<%-- <center><h1>ADD PROJECT</h1></center><br> --%>
			<h3 align="center">ADD PROJECT</h3>
	<br><br>
		<table border="1" align="center" cellpadding="5" cellspacing="5">
			<tr>
				<td>Project Name</td>
				<td><form:input type="text" path="projectName" id="projectName" onblur="addProject()" />
				<span id="pname" style="color: red"></span></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="date" id="startDate" name="projectStartDate" placeholder="YYYY-MM-DD" onblur="addProject()">
				 <span id="sdate" style="color: red"></span>
				</td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="date"  id="endDate" name="projectEndDate" placeholder="YYYY-MM-DD" onblur="addProject()"><span id="edate" style="color: red"></span></td>
			</tr>
			<tr>
				<td>Priority</td>
				<td><form:input type="range" path="priority" id="priority" maxlength="100" onblur="addProject()"/>
				 <span id="perror" style="color: red"></span>
				</td>
			</tr>
			<tr>
				<td>Manager</td>
				<td><input type="text" name="employee"  id="managerName" ><!-- readonly="readonly" value="${ sessionScope.employee.userName }"--> <span id="merror" style="color: red"></span><br />
				</td>
			</tr>
			<tr><td></td>
				<td><input type="submit" value="ADD"> 
				<input type="reset" value="RESET">
				<!-- <input type="submit" name="submit" class="submit" value="Search" /> -->
				</td>
			</tr>
	</table>
	<%-- <center><a href="/project/searchProject">search project</a></center> --%>
	</form:form>
</body>
<script type="text/javascript">
function addProject()
{
	 var Projectname=document.getElementById("projectName").value;
	 var StartDate=document.getElementById("startDate").value;
	 var EndDate=document.getElementById("endDate").value;
	 var Priority=document.getElementById("priority").value;
	 var Manager=document.getElementById("managerName").value;

	/*  var startDate = new Date($('#startDate').val());
	 var endDate = new Date($('#endDate').val()); */

	 if (StartDate < EndDate){
		 document.getElementById("sdate").innerHTML = "End Date greater than start date!!!!";
	 } 
	 
	 if (Projectname =="") {
			document.getElementById("pname").innerHTML = "Please Enter Project Name!!!";
			
		} else {
			document.getElementById("pname").innerHTML = " ";
		}
		
	 if (StartDate =="") {
			document.getElementById("sdate").innerHTML = "Please Enter Start Date!!!";
			
		} else {
			document.getElementById("sdate").innerHTML = " ";
		}
		
	 if (EndDate =="") {
			document.getElementById("edate").innerHTML = "Please Enter End Date!!!";
			
		} else {
			document.getElementById("edate").innerHTML = " ";
		}

	 if (Priority =="") {
			document.getElementById("perror").innerHTML = "Please Select Priority!!!";
			
		} else {
			document.getElementById("perror").innerHTML = " ";
		}

	 if (Manager =="") {
			document.getElementById("merror").innerHTML = "Please Enter Manager Name!!!";
			
		} else {
			document.getElementById("merror").innerHTML = " ";
		}



	 if(Projectname=="" || StartDate=="" || EndDate=="" || Priority=="" || Manager=="" )
		{
		return false;
		}
	
	 
	 return true;
		
}

</script>
</html>