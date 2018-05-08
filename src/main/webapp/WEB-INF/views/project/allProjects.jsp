<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%-- <%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor"	prefix="compress"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>	


<br>
	<spring:url value="/project/search" var="searchUrl"/>
	<form:form action="${ searchUrl }" method="POST">
	<center>
	
		<input type="text" id="searchproject" name="searchName"	placeholder="Search" required="required"> 
		<input type="submit" value="Search"><br><p></p>
		<label>Sort By</label>
		<a href="/project/sortOnStartDate"><input type="button" value="Start-Date"></a>
		<a href="/project/sortOnLastDate"><input type="button" value="End-Date"></a>
		<a href="/project/priority"><input type="button" value="Priority"></a>
		
		</center>
	</form:form>
<form action="/project/showEditProject" method="post" modelAttribute="project">
		<table border="1" align="center" cellpadding="5" cellspacing="5">
		<caption><h2><b><u>Project Details</u></b></b><h2></h2></caption><p>
			<thead>
				<tr>
					<th>project</th>
					<th>StartDate</th>
					<th>EndDate</th>
					<th>Priority</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projects}" var="p">
					<tr>
						
						
						<td><c:out value="${ p.projectName }"></c:out></td>
						<td><c:out value="${ p.projectStartDate }"></c:out></td>
						<td><c:out value="${ p.projectEndDate }"></c:out></td>
						<td><c:out value="${ p.priority }"></c:out></td> 

						<td><input type="hidden" name="projectId" value="${ p.projectId }">
						<input type="submit" name="action" value="Update"> <br> <br>
						<!-- <input type="submit" name="action" value="Suspend"></td> -->

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</form>
	
</body>
</html>