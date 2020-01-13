<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Book</title>
</head>
<body>
	<div id="wrapper">
			<div id="header">
				<h2>Modify Book</h2>
			</div>
			<div id="container">
				<form:form action="updateBook" modelAttribute="book" method="POST">
					<table>
						<tbody>
							
							<!-- That we know witch Book to modify -->
							<form:hidden path="id"/>
							
							<tr>
								<td><label>Title:</label></td>
								<td><form:input path="title" /></td>
							</tr>
							<tr>
								<td><label>Date of creation:</label></td>
								<td><form:input path="doc" /></td>
							</tr>
							<tr>
								<td><label>Pages:</label></td>
								<td><form:input path="pages" /></td>
							</tr>
							<tr>
								<td><label>Genre:</label></td>
								<td><form:select path="genre">
									<form:option value="NONE"> --SELECT-- </form:option>
									<c:forEach var="gener" items="${geners}">
										<form:option value="${gener.id}">${gener.name}</form:option>
									</c:forEach>
								</form:select></td>
							</tr>
							<tr>
								<td><label>Author:</label></td>
								<td><form:select path="author">
									<form:option value="NONE"> --SELECT- -</form:option>
									<c:forEach var="author" items="${authors}">
										<form:option value="${author.id}">${author.firstName} ${author.lastName}</form:option>
									</c:forEach>
								</form:select></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="SAVE" class="button"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>	
				<br></br>
				<button onclick="window.location.href='books'" class="button">Back to the list</button>
			</div>
		</div>
</body>
</html>