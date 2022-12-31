<%@page import="com.Coupon.Dao.ProductDaoImpl"%>
<%@page import="com.Coupon.Dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@page import="com.Coupon.Model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="table.css" />
</head>
<body>

	<%
	String name = (String) session.getAttribute("name");

	if (name != null && name.equals("admin")) {
	} else {
		response.sendRedirect("login.html");
	}

	ProductDao pd = new ProductDaoImpl();
	List<Product> list = pd.getAllProducts();
	request.setAttribute("list", list);
	%>

	<jsp:include page="Adminheader.html"></jsp:include>
	<div align="center">

		<form action="###" method="post">

			<table class="styled-table">
				<tr>
					<td colspan="2" align="center"><h1>Product List</h1>
				</tr>
				<tr>

					<th>Name</th>
					<th>Price</th>
					<th>Disciption</th>
				</tr>
				<c:forEach var="p" items="${list}">
					<tr>
						<td><c:out value="${p.getName()}" /></td>
						<td><c:out value="${p.getPrice()}" /></td>
						<td><c:out value="${p.getDiscription()}" /></td>

					</tr>
				</c:forEach>

			</table>
		</form>
	</div>


</body>
</html>