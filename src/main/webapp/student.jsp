
<%@ page import="com.ace.ai.web.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
<%@ include file="menu.jsp" %>   
	<h2> Student page</h2>
		<%@ include file="contextText.jsp" %>
		
	<table>
		<tr>
			<th>User Name</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Age</th>
			<th>Class Name</th>
		</tr>

		<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		for (Student student : students) { %>
			<tr>
				<td><%=student.getName() %></td>
				<td><%=student.getPhone() %></td>
				<td><%=student.getEmail() %></td>
				<td><%=student.getAge() %></td>
				<td><%=student.getClassName() %></td>
			</tr>
		<% } %>


	</table>
</body>
</html>