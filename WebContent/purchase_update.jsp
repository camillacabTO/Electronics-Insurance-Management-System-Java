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

	
<form action="UpdatePurchaseServlet">
	
		<p>Purchase ID: <input type="text" name="purchaseid" value="${param.purchaseid}" readonly></p>
	
		<p>Login-id (Username): <input type="text" name="username" value="${param.username}" readonly></p>
		 
 		<p>	Productname:
			 <select id="Productname" name="productname" style="width: 200px;height: 20px; vertical-align: middle; line-height: 40px;">
				
				<option>"${param.productname}"</option>
				
					<c:forEach var="InventoryProduct" items="<%=request.getAttribute(\"InventoryProducts\") %>">
				
						<option value="${InventoryProduct.productname}">${InventoryProduct.productname}</option>
			
					</c:forEach>
			 </select>
		</p>
	 
		<p>Serial No: <input type="text" name="serialno" value="${param.serialno}"></p>
		<p>Purchase Date: <input type="text" name="purchasedate" value="${param.purchasedate}"></p>	 
		<p>Available Claims: <input type="text" name="availableclaims" value="${param.availableclaims}"></p>	 
		<p> <input type="submit" value="Update"></p>
	
	
	<a href="QueryAllProductServlet">Go Back</a>
	
	
	</form>
	
	
</body>
</html>