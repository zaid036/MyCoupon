<%@ page import="com.Coupon.Model.*"%>
<%@ page import="com.Coupon.Dao.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coupon</title>
<link rel="stylesheet" href="table.css" />
</head>
<body>
	<%
	String name = (String) session.getAttribute("name");

	if (name == null) {

		response.sendRedirect("index.html");
	}
	CouponDao pd = new CouponDaoImpl();
	List<Coupon> list = pd.getAllCoupon();
	request.setAttribute("list", list);
	%>
<div align="left">
		Username :
		<%=name%></div>
	<jsp:include page="Userheader.html"></jsp:include>
	<div align="center">

		<form action="###" method="post">

			<table class="styled-table">
				<tr>
					<td colspan="2" align="center"><h1>Coupons</h1>
				</tr>
				<tr>

					<th>Coupon Code</th>
					<th>Off</th>
					<th>Expiry Date</th>
				</tr>
				<c:forEach var="c" items="${list}">
					<tr>
						<td><c:out value="${c.getCoupon_Code()}" /></td>
						<td><c:out value="${c.getDiscount()}" /></td>
						<td><c:out value="${c.getExp_date()}" /></td>

					</tr>
				</c:forEach>

			</table>
		</form>
	</div>




</body>
</html>