<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Page</title>
</head>
<body>
<h2>Viewing the list populated from Model</h2>

<c:if test="${data ne null }">
<table border="1">
<tr>
<th>Name
</th>
<th>Date
</th>
<th>Description
</th>
<th>Quantity
</th>
<th>Price
</th>
</tr>

<c:forEach items="${data}" var="user">
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
</c:forEach>
</table>
</c:if>

<c:if test="${data eq null }">
<p>
There are no records to display
</p>
</c:if>
</body>
</html>