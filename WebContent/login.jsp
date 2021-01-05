<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>

<form action="LoginServlet">

	<p> Username: <input type="text" name = "username" /></p>
	<p> Password: <input type="password" name = "password" /></p>
	
	<p>  <input type="submit" value = "Login" /></p>
		
</form>

<p><a href="customer_register.jsp">Sign Up</a></p>

</body>
</html>