<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Task</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	function addTask() {
		var Task = document.getElementById("taskname").value;
		var ParentTask = document.getElementById("parentTaskId").value;
		var StartDate = document.getElementById("taskStartDate").value;
		var EndDate = document.getElementById("taskEndDate").value;

		if ((Date.parse(StartDate) >= Date.parse(EndDate))) {
			alert("End date should be greater than Start date");
			document.getElementById("taskEndDate").value = "";
		}

		if (Task == "") {
			document.getElementById("taskerror").innerHTML = "please enter Task_Name";

		} else {
			document.getElementById("taskerror").innerHTML = " ";
		}
		if (ParentTask == "") {
			document.getElementById("parenterror").innerHTML = "please enter ParentTask_Name";

		} else {
			document.getElementById("parenterror").innerHTML = " ";
		}
		if (StartDate == "") {
			document.getElementById("sd").innerHTML = "please enter StartDate";

		} else {
			document.getElementById("sd").innerHTML = " ";
		}
		if (EndDate == "") {
			document.getElementById("ed").innerHTML = "please enter EndDate";

		} else {
			document.getElementById("ed").innerHTML = " ";
		}

		if (Task == "" || ParentTask == "" || StartDate == "" || EndDate == "") {
			return false;
		}

		return true;

	}
</script>
</head> 
<body>
	<h3 align="center">Add Task</h3>

	<spring:url value="/task/addTask" var="TaskAddUrl" />
	<form:form modelAttribute="task" action="${ TaskAddUrl }"
		onSubmit="return addTask()">


		<table border="1" align="center">
			<tr>
				<th>PROJECT MANAGER</th>
			</tr>
			<tr>
				<td><label>project:</label> 
				<form:select path="assignProject.projectName">
						<form:options items="${ projectNames }" />
					</form:select>
			</tr>
			<tr>
				<td><label>Task</label> <form:input type="text" path="taskName"
						id="taskname" size="25" maxlength="50" class="field" /> <span
					id="taskerror" style="color: red">*</span></td>

			</tr>
			<tr>
				<td><form:checkbox path="status" value="Status" /><label>Parent
						Task</label></td>
			</tr>
			<tr>
				<td><label>Priority:</label> <form:input type="range"
						minlength="0" maxlength="30" path="priority" /></td>
			</tr>

			<tr>
				<td><label>Start-Date</label> <form:input type="date"
						path="taskStartDate" id="taskStartDate" /><span id="sd"
					style="color: red">*</span></td>
			</tr>
			<tr>
				<td><label>End-Date</label> <form:input type="date"
						path="taskEndDate" id="taskEndDate" /><span id="ed"
					style="color: red">*</span></td>
			</tr>
			<tr>
				<td><label>Employee</label>
				<form:select path="employee.emailId">
						<form:options items="${employeeIds}" />
					</form:select>
			</tr>
			<tr>
				<td><input type="submit" value="addTask" /> 
					<input type="submit" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>