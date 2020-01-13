<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> List Of All Books </h2>
		</div>
	</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<button onclick="window.location.href='addBook'" class="button">Add New Book</button>
	<br></br>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Title</th>
					<th>Date of creation</th>
					<th>Pages</th>
					<th>Genre</th>
					<th>Author</th>
					<th></th>
					<th>Action</th>
				</tr>			
				
				<!-- Loop over and print books -->
				<c:forEach var="tempBook" items="${books}">
				
					<!-- Construct "Modify" link with Book ID -->
					<c:url var="modifyLink" value="/modifyBook">
						<c:param name="bookId" value="${tempBook.id}"></c:param>
					</c:url>
					
					<!-- Construct "Remove" link with Book ID -->
					<c:url var="removeLink" value="/removeBook">
						<c:param name="bookId" value="${tempBook.id}"></c:param>
					</c:url>
					
				<tr>
					<td>${tempBook.title}</td>
					<td>${tempBook.doc}</td>
					<td>${tempBook.pages}</td>
					<td>${tempBook.genre.name}</td>
					<td>${tempBook.author.firstName} ${tempBook.author.lastName}</td>
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