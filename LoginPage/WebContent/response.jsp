<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
<script type="text/javascript">
function callMe(){
	document.getElementById('myForm').action = "logout.do";	
	document.getElementById('myForm').submit();
}


</script>


</head>
<body>
<%String msg = (String)request.getAttribute("msg");
if("success".equalsIgnoreCase(msg)){
%>
<form id="myForm" method="post" action="">
<h1>Welcome, <%=(String) request.getAttribute("username") %></h1>
 <h4>You have successfully logged in!!</h4>
 <input type="hidden" value="logout" name="action"/>
 <a href="javascript:callMe();" >Please click here to logout!</a>
 </form>
<%	
}
else{
	%>
	<h1> Bad Login!</h1>
	<a href="index.jsp">Go Back</a>
	<%
}

%>

</body>
</html>