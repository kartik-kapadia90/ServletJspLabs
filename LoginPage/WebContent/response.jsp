<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>
<%String msg = (String)request.getAttribute("msg");
if("success".equalsIgnoreCase(msg)){
%>
<h1>Welcome, <%=(String) request.getAttribute("username") %></h1>

<%	
}
else{
	%>
	<h1> Bad Login!</h1>
	
	<%
}

%>
<a href="index.jsp">Go Back</a>
</body>
</html>