<%@ page import="com.Coupon.Model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
<link rel="stylesheet" href="table.css" />
</head>
<body>


	<%
	String name = (String) session.getAttribute("name");

	if (name == null) {

		response.sendRedirect("index.html");
	}

	Object obj = request.getAttribute("product");
	Object obj1 = request.getAttribute("coupon");
	Product p = (Product) obj;
	Coupon c = (Coupon) obj1;
	request.setAttribute("p", p);
	request.setAttribute("c", c);
	%>
	<div align="left">
		Username :
		<%=name%></div>
	<jsp:include page="Userheader.html"></jsp:include>
	<div align="center">


		<form action="order" method="post">
			<table class="styled-table">
				<tr>
					<td colspan="2" align="center"><h1>Order Details</h1>
				</tr>
				<tr>

					<th>Product Details</th>
					<th>Coupon Details</th>
				</tr>

				<tr>

					<td><input type="hidden" name="pid" value="${p.getId()}"><input
						type="text" name="pname" value="${p.getName()}"
						readonly="readonly"></td>
					<td><input type="hidden" name="cid" value="${c.getId()}"><input
						type="text" placeholder="Code" name="ccode"
						value="${c.getCoupon_Code()}" readonly="readonly"></td>
				</tr>
				<tr>

					<td><input type="text" name="pprice" value="${p.getPrice()}"
						readonly="readonly"></td>
					<td><input type="text" placeholder="Discount" name="cdiscount"
						value="${c.getDiscount()}" readonly="readonly"></td>
				</tr>
				<tr>

					<td><input type="text" name="pdiscription"
						value="${p.getDiscription()}" readonly="readonly"></td>
					<td><input type="text" placeholder="Expiry Date"
						name="cexpirydate" value="${c.getExp_date()}" readonly="readonly">
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Confirm"></td>
				</tr>


			</table>
	</div>
	</form>


</body>
</html>