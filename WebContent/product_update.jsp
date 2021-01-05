<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
 <h1> Update Product </h1>

	<form action="UpdateProductServlet">
	
		<p>Product Name: <input type="text" name="productname" value="${param.productname}" readonly></p>
		 <p>Category: <input type="text" name="category"  value="${param.category}" ></p>
		<p>Quantity: <input type="text" name="quantity"  value="${param.quantity}" ></p>
 
		<p> <input type="submit" value="Update"></p>
	
	</form>
	
</body>
</html>