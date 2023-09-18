<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome </title>
<%@ include file="css.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<h2>Welcome</h2>
		<%@ include file="contextText.jsp" %>
		${sessionScope.loginUserName }
	
	<%if(request.getSession().getAttribute("count") != null){ %>
	<h5> You visited ${sessionScope.count } time</h5>
	<%} %>
</body>
</html>