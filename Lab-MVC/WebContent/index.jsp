<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<p>Welcome to MVC Lab - Login Demo with Hibernate and MySql</p>

	<form name="login" method="POST" action="login.do">
		<input type="hidden" value="login" name="action" />
		<h1>Welcome to Login Demo</h1>
		<p>Instructions:</p>
		<p>Username should be atleast 6 characters long</p>
		<p>Password must be atleast 8 characters long</p>
		<br />
		<h3>Enter login credentials below</h3>
		<table>
			<tr>
				<td>Enter username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Enter password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<br /> <input type="submit" value="Submit" />
	</form>
	<!-- 	
<p>Please click on the below link to view a list</p>
<a href = "users.do">View List</a> -->
</body>
</html>