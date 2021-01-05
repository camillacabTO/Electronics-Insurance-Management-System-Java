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

<h1> Search Result -- Customer info</h1>
 

	<p> 
	 	<table border = 1px>
		 	<tr>
		 		<td>User Name</td>
		 		<td>CellPhoneNo</td>
		 		<td>Email</td>
		 		<td>Name</td>
				 <td>Address</td>
		 		<td>Delete</td>
		 		<td>Update</td>
		 	</tr>
	 	
			<c:set var="cust" value="${requestScope.queryUserByUsername}"></c:set>
			
				<tr>
			 		<td>${cust.username}</td>
			 		<td>${cust.cellphoneno}</td>
			 		<td>${cust.email}</td>
			 		<td>${cust.name}</td>
		  		 	<td>${cust.address}</td>
			 		<td><a href="DeleteCustomerServlet?username=${cust.username}">Delete</a></td>
			 		 
			 		 <td><a href="customer_update.jsp?username=${cust.username}">Update</a></td>
			 	</tr>
			 
		</table>
	</p>
	
	
	
	 
	
	<p><a href="QueryAllUserServlet">Show All Customers</a></p>

</body>
</html>