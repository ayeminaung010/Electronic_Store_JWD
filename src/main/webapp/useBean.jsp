<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Use Bean Exercise</title>
</head>
<body>

	<form action="useBean">
		<input type="submit" value="Refresh" >
	</form>
	
<%-- 	<jsp:useBean id="student" type="com.ace.ai.web.Student" class="com.ace.ai.web.Student" scope="request" /> --%>
<%-- 	<jsp:getProperty property="name" name="student" /> --%>
<%-- 	<jsp:getProperty property="email" name="student" /> --%>
	
<!-- 	expression language  -->
	<span>${student.name}</span>
	<span>${student.email}</span>

	<br/>
<%-- 	<jsp:useBean id="student1" type="com.ace.ai.web.Student" class="com.ace.ai.web.Student" scope="request" /> --%>
<%-- 	<jsp:getProperty property="name" name="student1" /> --%>
<%-- 	<jsp:getProperty property="email" name="student1" /> --%>
	
	${sessionScope.student1.name }
	${sessionScope.student1.email }
</body>
</html>