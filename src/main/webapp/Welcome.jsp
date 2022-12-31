<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Amazon</title>
</head>
<body>
	<%
	String name = (String) session.getAttribute("name");

	if (name == null) {

		out.print("Login First");
		request.getRequestDispatcher("index.html").include(request, response);
	}
	%>
	<div align="left">
		Username :
		<%=name%></div>
	<jsp:include page="Userheader.html"></jsp:include>

</body>
</html>