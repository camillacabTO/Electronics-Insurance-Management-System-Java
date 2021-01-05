<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>Welcome ${sessionScope.username}</h1>
 
	<p> 
		<a href="QueryAllProductServlet">Show All Registered items by Client</a>
	</p>


	<p> 
		<a href="QueryAllUserServlet">Show All User</a>
	</p>
	
	
	<p> 
		<a href="AdminQueryAllInventoryProductServlet">Show All Inventory Product</a>
	</p>
	
	<p> 
		<a href="AdminQueryAllClaimsServlet">Show All Claims</a>
	</p>
	
	<hr>
	<p><a href="login.jsp">Logout</a></p>
</body>
</html>