<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="css.jsp"%>
</head>
<body>

	<%-- <form action="login" method="post">
		Username : <input type="email" name="email"
			value="<%=(request.getAttribute("rememberUser") != null) ? request.getAttribute("rememberUser") : ""%>">
		<br> Password : <input type="password" name="password">
		<br> Remember User ? <input type="checkbox" name="isRememberUser" />
		<input type="hidden" name="loginDateTime"
			value="<%=(new java.util.Date().toString())%>" /> <input
			type="submit" value="login">
	</form> --%>



	<div class="container">
		<div
			class="form-container  min-vh-100 d-flex justify-content-center align-items-center ">
			<form action="welcome" method="post"
				class=" w-50  border border-dark shadow  p-5">
				<div class=" text-center">
					<h4 class=" fw-bold text-uppercase">Login Page</h4>
									<em>${message}</em>
				</div>
				<div class=" p-4">
					<label class=" text-uppercase fw-semibold" for="username">Email</label>
					<input type="email" name="email" id="email"
						class="form-control px-5 py-2 mt-2 rounded-0 py-2"
						placeholder="Enter Email">
				</div>
				<div class=" p-4">
					<label class=" text-uppercase fw-semibold" for="password">Password</label>
					<input type="password" name="password" id="password"
						class="form-control px-5 py-2 mt-2 rounded-0 py-2"
						placeholder="Enter Password">
				</div>
				<div class=" p-4">
					<label class=" text-uppercase fw-semibold" for="Remember_me">Remember
						Me</label> <input type="checkbox" name="isRememberUser" class="" />
				</div>

				<div class=" my-2 ">
					<input type="hidden" name="loginDateTime"
						value="<%=(new java.util.Date().toString())%>" />
				</div>

				<div class=" text-end pe-4">
					<button type="submit"
						class=" btn btn-dark px-5 py-2 text-uppercase rounded-0">Log
						In</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>