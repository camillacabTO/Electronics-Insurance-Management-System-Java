<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add Product</h1>
	<form action="AdminAddProductServlet">
	
		<p>Product Name: <input type="text" name="productname" ></p>
		 <p>Category: <input type="text" name="category"></p>
		<p>Quantity: <input type="number" name="quantity"></p>
		 
		<p> <input type="submit" value="Add Product"></p>
	
	</form>
	
	
</body>
</html>