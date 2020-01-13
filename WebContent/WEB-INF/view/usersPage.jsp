<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> List Of All Users </h2>
		</div>
	</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<button onclick="window.location.href='addUser'" class="button">Add New User</button>
	<br></br>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DoB</th>
					<th>Country</th>
					<th>City</th>
					<th>Address</th>
					<th>Gender</th>
					<th>Job Title</th>
					<th>Description</th>
					<th>Salary</th>
					<th></th>
					<th>Action</th>
				</tr>			
				
				<!-- Loop over and print Users  -->
				<c:forEach var="tempUser" items="${users}">
				
					<!-- Construct "Modify" link with User ID -->
					<c:url var="modifyLink" value="/modifyUser">
						<c:param name="UserId" value="${tempUser.id}"></c:param>
					</c:url>
					
					<!-- Construct "Remove" link with User ID -->
					<c:url var="removeLink" value="/removeUser">
						<c:param name="UserId" value="${tempUser.id}"></c:param>
					</c:url>
					
				<tr>
					<td>${tempUser.firstName}</td>
					<td>${tempUser.lastName}</td>
					<td>${tempUser.dob}</td>
					<td>${tempUser.country}</td>
					<td>${tempUser.city}</td>
					<td>${tempUser.address}</td>
					<td>${tempUser.gender}</td>
					<td>${tempUser.job.jobTitle}</td>
					<td>${tempUser.job.description}</td>
					<td>${tempUser.job.salary} RSD</td>
					<td>---></td>
					<td><button onclick="window.location.href='${modifyLink}'">Modify</button></td>
					<td> | </td>
					<td><button onclick="if (confirm('Is it OK to proceed deleting?'))window.location.href='${removeLink}'" id="deleteButton">Remove</button></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>