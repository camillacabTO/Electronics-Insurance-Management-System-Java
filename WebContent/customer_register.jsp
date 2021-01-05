<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Sign Up</h1>
	<form action="AddCustomerServlet">
	
		<p>Username: <input type="text" name="username" ></p>
		 <p>Password: <input type="password" name="password"></p>
		<p>CellPhone: <input type="text" name="cellphoneno"></p>
		<p>Email: <input type="email" name="email"></p>
		<p>Name: <input type="text" name="name"></p>
		<p>Address: <input type="text" name="address"></p>
		<p> <input type="submit" value="Register"></p>
	
	</form>
	
</body>
</html>