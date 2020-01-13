<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Read Books</title>
</head>
<body>
	<div id="wrapper">
			<div id="header">
				<h2>User Read Books</h2>
			</div>
	<button onclick="window.location.href='home'" class="button">Back to HomePage</button>
	<br></br>
			<div id="container">
				<form:form action="saveReadBook" modelAttribute="users" method="POST">
					<table>
						<tbody>
							<tr>
								<th>User</th>
								<th></th>
							</tr>
							<tr>
								<!-- Selectt options USERS -->
								<td><form:select path="">
									<form:option value="NONE"> --SELECT- -</form:option>
									<c:forEach var="user" items="${users}">
										<form:option value="${user.id}">${user.firstName} ${user.lastName}</form:option>
									</c:forEach>
								</form:select></td>
							</tr>
							<tr>
							<form:form modelAttribute="books" method="POST">
								<c:forEach var="book" items="${books}">
								
									<!-- checkbox for all BOOKS 
										<form:checkbox path="books" value="${book}" label="${book.title}" />
										<td><c:out value="${book.title}" /></td> -->
					
								</c:forEach>
							</form:form>
							</tr>
						</tbody>
					</table>
				</form:form>	
			</div>
		</div>
</body>
</html>