<%@ page import="com.ace.ai.web.Class, java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<h2> CLass page</h2>
		<%@ include file="contextText.jsp" %>
		
	<table>
		<tr>
			<th>Course </th>
			<th>Instructor </th>
			<th>Date</th>
		</tr>
		<%
			List<Class> classes =(List <Class>) request.getAttribute("classes");
			for (Class classobj : classes){
		%>
			<tr>
				<td><%=classobj.getCourse() %></td>
				<td><%=classobj.getInstructorNameString() %></td>
				<td><%=classobj.getDate() %></td>
			</tr>
		<%} %>
		
	</table>
</body>
</html>