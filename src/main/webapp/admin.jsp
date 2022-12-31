
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
	<%!int count;%>

	<%
	String name = (String) session.getAttribute("name");
	String can = request.getParameter("candidate");
	if (name != null && name.equals("admin")) {

	} else {
		response.sendRedirect("index.html");
	}
	%>

<jsp:include page="Adminheader.html"></jsp:include>
	

</body>
</html>