<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>

	<form action="changePassword" method="post">
		
		Old Password: <input type="password" name="oldPassword" > <br/>
		New Password: <input type="password" name="newPassword" > <br/>
		Confirm Password : <input type="password" name="confirmPassword" > <br/>
		
		<input type="hidden" value="${updateUser}" name="id">
		
		<input type="submit" value = "Update">
	
	</form>
	
</body>
</html>