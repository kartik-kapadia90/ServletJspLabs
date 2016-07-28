<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Page</title>
<script type="text/javascript">
	function callMe() {
		document.getElementById('myForm').action = "logout.do";
		document.getElementById('myForm').submit();
	}
</script>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		if ("success".equalsIgnoreCase(msg)) {
	%>
	<form id="myForm" method="post" action="">
		<h1>
			Welcome,
			<%=(String) request.getAttribute("username")%></h1>
		<h4>You have successfully logged in!!</h4>
		<input type="hidden" value="logout" name="action" /> <a
			href="javascript:callMe();">Please click here to logout!</a>


		<h2>Viewing the details for this user</h2>

		<c:if test="${data ne null }">
			<table border="1">
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<tr>
					<td><c:out value="${data.name}" /></td>
					<td><c:out value="${data.date}" /></td>
					<td><c:out value="${data.description}" /></td>
					<td><c:out value="${data.quantity}" /></td>
					<td><c:out value="${data.price}" /></td>
				</tr>
				<%-- <c:forEach items="${data}" var="user">
						<tr>
						<td>
						<c:out value="${user.name}"/>
						</td>
						  <td>
						<c:out value="${user.date}"/>
						</td>
						<td>
						<c:out value="${user.description}"/>
						</td>
						<td>
						<c:out value="${user.quantity}"/>
						</td>
						<td>
						<c:out value="${user.price}"/>
						</td>
						 </tr>
					 </c:forEach> --%>
			</table>
		</c:if>

		<c:if test="${data eq null }">
			<p>There are no records to display</p>
		</c:if>


	</form>
	<%
		} else {
	%>
	<h1>Bad Login!</h1>
	<a href="index.jsp">Go Back</a>
	<%
		}
	%>





</body>
</html>