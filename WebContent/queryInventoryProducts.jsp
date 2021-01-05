<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>  All Inventory Product</h1>

	<p> 
	 	<table border = 1px>
		 	<tr>
		 		<td>Productname</td>
		 		<td>Category</td>
		 		<td>Quantity</td>
		 		<td>Delete</td>
		 		<td>Update</td>
		 	</tr>
	 	
			<c:forEach var="lproduct" items="${requestScope.inventoryProducts}">
			
				<tr>
			 		<td>${lproduct.productname}</td>
			 		<td>${lproduct.category}</td>
			 		<td>${lproduct.quantity}</td>
			 	 
		  		 
			 		<td><a href="DeleteInventoryProductServlet?productname=${lproduct.productname}">Delete</a></td>
			 		 
			 		 <td><a href="product_update.jsp?productname=${lproduct.productname}&category=${lproduct.category}&quantity=${lproduct.quantity}">Update</a></td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
	
	<form action="AdminSearchByInventoryProduct">
		<p>
			Search Inventory Product: <input type="text" name="searchInventoryProduct"/>
			<input type="submit" value="Search"/> 
		</p>
	</form>
	
	<hr>
	
	<p>	
		<a href="addProduct.jsp">Add Product</a>
	</p>
	
	<hr>
	
	<p>
		<a href="AdminMainPage.jsp">back to Main Page</a>
	</p>

</body>
</html>