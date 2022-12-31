<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="table.css" />
</head>
<body>
	<%
	String name = (String) session.getAttribute("name");

	if (name != null && name.equals("admin")) {

	} else {
		response.sendRedirect("index.html");
	}
	%>

<jsp:include page="Adminheader.html"></jsp:include>
	<div align="center">

		<form action="add" method="post">

			<table class="styled-table">
				<tr>
					<td colspan="2" align="center"><h1>Coupon Details</h1> <input
						type="hidden" name="add" value="coupon" ></td>
				</tr>
				<tr>

					<td>Code</td>
					<td><input type="text" name="coupon_Code" required="required">
					</td>
				</tr>
				<tr>
					<td>Discount</td>
					<td><input type="number" name="discount" required="required">
					</td>
				</tr>
				<tr>
					<td>Expiry Date</td>
					<td><input type="text" name="exp_date" required="required">
					</td>
				</tr>
				<tr>

					<td colspan="2" align="center"><input type="submit"
						value="Add Coupon" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>