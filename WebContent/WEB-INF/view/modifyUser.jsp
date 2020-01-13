<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify User</title>
</head>
<body>
	<div id="wrapper">
			<div id="header">
				<h2>Modify Author</h2>
			</div>
			<div id="container">
				<form:form action="updateUser" modelAttribute="user" method="POST">
					<table>
						<tbody>
							
							<!-- That we know witch User to modify -->
							<form:hidden path="id"/>
							
							<tr>
								<td><label>First Name:</label></td>
								<td><form:input path="firstName" /></td>
							</tr>
							<tr>
								<td><label>Last Name:</label></td>
								<td><form:input path="lastName" /></td>
							</tr>
							<tr>
								<td><label>DoB:</label></td>
								<td><form:input path="dob" /></td>
								<td><label>Example (yyyy-MM-dd)</label></td>
							</tr>
							<tr>
								<td><label>Country:</label></td>
								<td><form:input path="country" /></td>
							</tr>
							<tr>
								<td><label>City:</label></td>
								<td><form:input path="city" /></td>
							</tr>
							<tr>
								<td><label>Address:</label></td>
								<td><form:input path="address" /></td>
							</tr>
							<tr>
								<td><label>Gender:</label></td>
								<td><form:select path="gender">
									<form:option value="Male"> Male </form:option>
									<form:option value="Female"> Female </form:option>
								</form:select></td>
							</tr>
							<tr>
								<td><label>Job Title:</label></td>
								<td><form:input path="job.jobTitle" /></td>
							</tr>
							<tr>
								<td><label>Description:</label></td>
								<td><form:input path="job.description" /></td>
							</tr>
							<tr>
								<td><label>Salary:</label></td>
								<td><form:input path="job.salary" /></td>
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