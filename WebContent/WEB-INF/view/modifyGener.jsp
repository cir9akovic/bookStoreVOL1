<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Genre</title>
</head>
<body>
		<div id="wrapper">
			<div id="header">
				<h2>Modify Genre</h2>
			</div>
			<div id="container">
				<form:form action="saveOrUpdateGener" modelAttribute="gener" method="POST">
					<table>
						<tbody>
							
							<!-- That we know witch Author to modify -->
							<form:hidden path="id"/>
							
							<tr>
								<td><label>Name:</label></td>
								<td><form:input path="name" /></td>
							</tr>
							<tr>
								<td><label>Description:</label></td>
								<td><form:input path="description" /></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="SAVE" class="button"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>	
				<br></br>
				<button onclick="window.location.href='geners'" class="button">Back to the list</button>
			</div>
		</div>
</body>
</html>