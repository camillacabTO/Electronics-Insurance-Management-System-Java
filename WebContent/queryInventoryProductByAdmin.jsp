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

  ${requestScope.searchInventoryProduct}
<h1>  Search Product</h1>

	<p> 
	 	<table border = 1px>
		 	<tr>
		 		 
		 		<td>ProductName</td>
		 		<td>Category</td>
		 		<td>Quantity</td>
		 
		 		<td>Delete</td>
		 		<td>Update</td>
		 	</tr>
	 	
	 	<%--one record, can't use foreach tag --%>
			<c:set var="plist" value="${requestScope.searchInventoryProduct}"/>
			
				<tr>
			 		 
			 		<td>${plist.productname}</td>
			 		<td>${plist.category}</td>
			 		<td>${plist.quantity}</td>
		  		 
			 		<td><a href="DeleteInventoryProductServlet?productname=${plist.productname}">Delete</a></td>
			 		 
			 		 <td><a href="product_update.jsp?productname=${plist.productname}&category=${plist.category}&quantity=${plist.quantity}">Update</a></td>
			 	</tr>
			 
		</table>
	</p>
 
	
	
	<a href="AdminQueryAllInventoryProductServlet">back to Main Page</a>


</body>
</html>