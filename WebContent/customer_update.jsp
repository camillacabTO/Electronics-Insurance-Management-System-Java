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
 <h1> Update Customer </h1>

	<form action="UpdateCustomerServlet">
	
		<p>Username: <input type="text" name="username" value="${param.username}" readonly></p>
		 <p>Password: <input type="text" name="password"></p>
		<p>CellPhone: <input type="text" name="cellphoneno"></p>
		<p>Email: <input type="email" name="email"></p>
		<p>Name: <input type="text" name="name"></p>
		<p>Address: <input type="text" name="address"></p>
		<p> <input type="submit" value="Update"></p>
	
	</form>
	
</body>
</html>