<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Demo</title>
</head>
<body>

<form name="login" method="POST" action="login.do">
<p>Instructions:</p>
<p>Username should be atleast 6 characters long</p>
<p>Password must be atleast 8 characters long</p>
<br />
Enter username: <input type="text" name="username" />
<br />
Enter password: <input type="password" name="password" />
<br />
<input type="submit" value="Submit" />
</form>
</body>
</html>