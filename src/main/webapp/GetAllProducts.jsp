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

	if (name == null) {

		response.sendRedirect("index.html");
	}

	ProductDao pd = new ProductDaoImpl();
	List<Product> list = pd.getAllProducts();
	request.setAttribute("list", list);
	%>
<div align="left">
		Username :
		<%=name%></div>
	<jsp:include page="Userheader.html"></jsp:include>
	<div align="center">



		<table class="styled-table">
			<tr>
				<td colspan="4" align="center"><h1>Products</h1>
			</tr>
			<tr>

				<th>Name</th>
				<th>Price</th>
				<th>Disciption</th>
				<th>Coupon Code</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${list}">
				<tr>
					<form action="buy" method="get">
					<td><input type="hidden" name="productid" value="${p.getId()}"><c:out value="${p.getName()}" /></td>
					<td><c:out value="${p.getPrice()}" /></td>
					<td><c:out value="${p.getDiscription()}" /></td>
					<td><input type="text" name="couponcode"></td>
                    <td><input type="submit" value="BUY" /></td>

					</form>
				</tr>
			</c:forEach>

		</table>

	</div>


</body>
</html>