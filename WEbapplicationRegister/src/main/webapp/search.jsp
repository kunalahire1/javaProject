<%@page import="bank.login.register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="search">
Enter registration number <input type="text" name="regNo">
<input type="submit" value="search">
</form>
	<%!register r;%>

	<%
	if(!session.isNew());
	{
		r=(register)session.getAttribute("data");
%>
	<table>
		<tr>
		    <td><%=r.getRegNo() %></td>
			<td><%=r.getuName() %></td>
			<td><%=r.getAccBal()%></td>
			<td><%=r.getPassword() %></td>
           
</tr>
</table>
	<%} %>
</body>
</html>