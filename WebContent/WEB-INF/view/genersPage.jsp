<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genres</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> List Of All Genres </h2>
		</div>
	</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<button onclick="window.location.href='addGener'" class="button">Add New Genre</button>
	<br></br>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>			
				
				<!-- Loop over and print genres -->
				<c:forEach var="tempGener" items="${geners}">
				
					<!-- Construct "Modify" link with Genre ID -->
					<c:url var="modifyLink" value="/modifyGener">
						<c:param name="generId" value="${tempGener.id}"></c:param>
					</c:url>
					
					<!-- Construct "Remove" link with Genre ID -->
					<c:url var="removeLink" value="/removeGener">
						<c:param name="generId" value="${tempGener.id}"></c:param>
					</c:url>
					
				<tr>
					<td>${tempGener.name}</td>
					<td>${tempGener.description}</td>
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