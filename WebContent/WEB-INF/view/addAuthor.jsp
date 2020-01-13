<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add New Author</title>
		<style>
			.error {color:red}
		</style>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Add New Author</h2>
			</div>
			<div id="container">
				<form:form action="saveOrUpdateAuthor" modelAttribute="author" method="POST">
					<table>
						<tbody>
							<tr>
								<td><label>First Name:</label></td>
								<td><form:input path="firstName" />
								<form:errors path="firstName" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td><label>Last Name:</label></td>
								<td><form:input path="lastName" />
								<form:errors path="lastName" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td><label>DoB:</label></td>
								<td><form:input path="dob" />
								<form:errors path="dob" cssClass="error"/>
								</td>
								<td><label>Example (yyyy-MM-dd)</label></td>
							</tr>
							<tr>
								<td><label>DoD:</label></td>
								<td><form:input path="dod" />
								<form:errors path="dod" cssClass="error"/></td>
								<td><label>Example (yyyy-MM-dd)</label></td>
							</tr>
							<tr>
								<td><label>Country:</label></td>
								<td><form:input path="country" />
								<form:errors path="country" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td><label>Gender:</label></td>
								<td><form:select path="gender">
									<form:option value="Male"> Male </form:option>
									<form:option value="Female"> Female </form:option>
								</form:select>
								<form:errors path="gender" cssClass="error"/>
								</td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="SAVE" class="button"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>	
				<br></br>
				<button onclick="window.location.href='authors'" class="button">Back to the list</button>
			</div>
		</div>
	</body>
</html>