<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
<script src="jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/authorsPage.js"/></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> List Of All Authors </h2>
		</div>
	</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<button onclick="window.location.href='addAuthor'" class="button">Add New Author</button>
	<br></br>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>DoB</th>
					<th>DoD</th>
					<th>Country</th>
					<th>Gender</th>
					<th></th>
					<th>Action</th>
				</tr>			
				
				<!-- Loop over and print authors -->
				<c:forEach var="tempAuthor" items="${authors}">
				
					<!-- Construct "Modify" link with Authors ID -->
					<c:url var="modifyLink" value="/modifyAuthor">
						<c:param name="authorId" value="${tempAuthor.id}"></c:param>
					</c:url>
					
					<!-- Construct "Remove" link with Authors ID -->
					<c:url var="removeLink" value="/removeAuthor">
						<c:param name="authorId" value="${tempAuthor.id}"></c:param>
					</c:url>
					
				<tr>
					<td>${tempAuthor.firstName}</td>
					<td>${tempAuthor.lastName}</td>
					<td>${tempAuthor.dob}</td>
					<td>${tempAuthor.dod}</td>
					<td>${tempAuthor.country}</td>
					<td>${tempAuthor.gender}</td>
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