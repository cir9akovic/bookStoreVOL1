<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Book</title>
<style>
			.error {color:red}
		</style>
</head>
<body>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Add New Book</h2>
			</div>
			<div id="container">
				<form:form action="saveBook" modelAttribute="newBook" method="POST">
					<table>
						<tbody>
							<tr>
								<td><label>Title:</label></td>
								<td><form:input path="title" />
								<form:errors path="title" cssClass="error"/></td>
							</tr>
							<tr>
								<td><label>Date of creation:</label></td>
								<td><form:input path="doc" />
								<form:errors path="doc" cssClass="error"/></td>
								<td><label>Example (yyyy-MM-dd)</label></td>
							</tr>
							<tr>
								<td><label>Pages:</label>
								<form:errors path="pages" cssClass="error"/></td>
								<td><form:input path="pages" /></td>
							</tr>
							<tr>
								<td><label>Genre:</label>
								<form:errors path="genre" cssClass="error"/></td>
								<td><form:select path="genre">
									<form:option value="NONE"> --SELECT-- </form:option>
									<c:forEach var="gener" items="${geners}">
										<form:option value="${gener.id}">${gener.name}</form:option>
									</c:forEach>
								</form:select></td>
							</tr>
							<tr>
								<td><label>Author:</label>
								<form:errors path="author" cssClass="error"/></td>
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