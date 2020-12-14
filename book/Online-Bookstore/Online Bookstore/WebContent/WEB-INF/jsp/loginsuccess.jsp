<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="cit285.book.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% if (session.getAttribute("username")==null) {
	 response.sendRedirect("login.jsp");
 }%>
 
 Welcome...
 you have logged in succesfully
</body>
</html>