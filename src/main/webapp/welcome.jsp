<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title> 
</head>
<body>      
    <%
	  // request email from servlet
	  String message = (String)request.getAttribute("message");
	  // print email 
	  out.println("<br>"+message);
	%>
</body>
</html>