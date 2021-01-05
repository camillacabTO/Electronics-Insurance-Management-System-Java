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
<h1> Welcome ${sessionScope.username}</h1>

<hr>
  
<h1>  All Registered  Product</h1>

	<p> 
	 	<table border = 1px>
		 	<tr>
		 	
		 		<td>Purchase ID</td> 
		 		<!-- added purchase ID to the purchase table -->
		 		<td>User Name</td>
		 		<td>Product Name</td>
		 		<td>Serial No</td>
		 		<td>Purchase Date</td>
		 		 <td>Available Claims</td>
		  <%-- Customer doesn't need to delete or update product
		 		<td>Delete</td>
		 		<td>Update</td>
		 --%>
		 		<td>Claims</td>
		 	</tr>
	 	
			<c:forEach var="cproduct" items="${requestScope.cust_products}">
			
				<tr>
					<td>${cproduct.purchaseid}</td>
			 		<td>${cproduct.username}</td>
			 		<td>${cproduct.productname}</td>
			 		<td>${cproduct.serialno}</td>
			 		<td>${cproduct.purchasedate}</td>
		  		 	 <td>${cproduct.availableclaims}</td>
		  		 <%-- Customer doesn't need to delete or update product
			 		<td><a href="DeleteServletController?id=${cproduct.username}">Delete</a></td>
			 		 
			 		 <td><a href="C_07_Update?id=${cproduct.username}">Update</a></td>
			 	--%>
			 		 <td><a href="claim_register.jsp?id=${cproduct.purchaseid}&username=${cproduct.username}">Open Claim</a></td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
 
 	 <%-- <a href="product_registeration.jsp">Register Product</a>   NO Drop down list --%>
	<a href="QueryInventoryProductServlet">Register Product</a> 
	<p><a href="view_claims.jsp?username=${sessionScope.username}">Manage Claims</a></p>
	
	<hr>
	
		<p><a href="login.jsp">Logout</a></p>

</body>
</html>