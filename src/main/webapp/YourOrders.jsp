<%@page import="com.Coupon.Dao.ProductDaoImpl"%>
<%@page import="com.Coupon.Dao.ProductDao"%>
<%@page import="com.Coupon.Dao.UserDaoImpl"%>
<%@page import="com.Coupon.Dao.UserDao"%>
<%@page import="com.Coupon.Model.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>You Orders</title>
<link rel="stylesheet" href="table.css" />
</head>
<body>

	<%!public Product getProduct(String pid) {
		ProductDao pd = new ProductDaoImpl();
		Product p = new Product();
		p = pd.getProduct(Integer.parseInt(pid));
		return p;
	}%>

	<%
	String name = (String) session.getAttribute("name");

	if (name == null) {

		response.sendRedirect("index.html");
	}
	UserDao ud = new UserDaoImpl();
	List<Order> list = ud.getAllOrders(name);

	request.setAttribute("list", list);
	%>
	<div align="left">
		Username :
		<%=name%></div>
	<jsp:include page="Userheader.html"></jsp:include>
	<div align="center">


		<form action="####" method="post">
			<table class="styled-table">
				<tr>
					<td colspan="5" align="center"><h3>Your Orders Details</h3>
				</tr>

				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Discription</th>
					<th>Discount Price</th>
					<th>Coupon Used</th>
				</tr>
				<c:forEach items="${list}" var="o">
                <tr>
                 <td><c:out value="${o.getProduct().getName()}"></c:out></td>
                 <td><c:out value="${o.getProduct().getPrice()}"></c:out></td>
                 <td><c:out value="${o.getProduct().getDiscription()}"></c:out></td>
                 <td><c:out value="${o.getPrice()}"></c:out></td>
                 <td><c:out value="${o.getCoupon_used()}"></c:out></td>
                 </tr>
				</c:forEach>





			</table>
		</form>

	</div>

</body>
</html>