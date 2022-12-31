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
					<td colspan="2" align="center"><h1>Product Details</h1>
					<input
						type="hidden" name="add" value="product" ></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td><input type="text" name="name" required="required">
					</td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" name="price" required="required">
					</td>
				</tr>
				<tr>
					<td>Discription</td>
					<td><input type="text" name="discription" required="required">
					</td>
				</tr>
				<tr>

					<td colspan="2" align="center"><input type="submit"
						value="Add Product" /></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>