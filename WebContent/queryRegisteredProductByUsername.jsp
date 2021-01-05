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

<h1>  All Registered Product By Customer</h1>

	<p> 
	 	<table border = 1px>
		 	<tr>
		 		<td>Purchase ID</td>
		 		<td>User Name</td>
		 		<td>Product Name</td>
		 		<td>Serial No</td>
		 		<td>Purchase Date</td>
		 		<td>Available Claims</td>
		 		<td>Delete</td>
		 		<td>Update</td>
		 		<td>Claim</td>
		 	</tr>
	 	
			<c:forEach var="lproduct" items="${requestScope.listproduct}">
			
				<tr>
					<td>${lproduct.purchaseid}</td>
			 		<td>${lproduct.username}</td>
			 		<td>${lproduct.productname}</td>
			 		<td>${lproduct.serialno}</td>
			 		<td>${lproduct.purchasedate}</td>
		  		    <td>${lproduct.availableclaims}</td>
			 		<td><a href="DeleteRegisterProductServlet?username=${lproduct.username}&productname=${lproduct.productname}">Delete</a></td>
			 		 
			 		<td><a href="AdminQueryAllProductForUpdatePurchaseServlet?purchaseid=${lproduct.purchaseid}&username=${lproduct.username}&productname=${lproduct.productname}&serialno=${lproduct.serialno}&purchasedate=${lproduct.purchasedate}&availableclaims=${lproduct.availableclaims}">Update</a></td>
			 		 
			 		 <td><a href="claim_register.jsp?id=${lproduct.purchaseid}">Open Claim</a></td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
	
	 
	
	<a href="QueryAllProductServlet">Show All Product</a>
	
</body>
</html>