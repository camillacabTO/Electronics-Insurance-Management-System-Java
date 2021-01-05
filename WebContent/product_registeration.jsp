<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>
</head>
<body>

	<%-- From AddCustomerServlet --%>
	
	 

	<form action="ProductRegistrationServlet">
	
		<p>Login-id (Username): <input type="text" name="username" value="${sessionScope.username}" readonly></p>
		 
 		<p>	Productname:
			 <select id="Productname" name="Productname" style="width: 200px;height: 20px; vertical-align: middle; line-height: 40px;">
				
				<option>Choose Product</option>
				
					<c:forEach var="InventoryProduct" items="<%=request.getAttribute(\"InventoryProducts\") %>">
				
						<option value="${InventoryProduct.productname}">${InventoryProduct.productname}</option>
			
					</c:forEach>
			 </select>
		</p>
	 
		<p>Serialno: <input type="text" name="serialno"></p>
		<p>Purchasedate: <input type="text" name="purchasedate"></p>	 
		<p> <input type="submit" value="Product_Register"></p>
	
	
	<a href="QueryRegisteredProductByCustomer">Go Back</a>
	
	
	</form>


</body>
</html>