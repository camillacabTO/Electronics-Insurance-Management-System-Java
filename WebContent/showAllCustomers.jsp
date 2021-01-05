<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer info</title>
</head>
<body>
  
<h1>  Customer info</h1>

	<p> 
	 	<table border = 1px>
		 	<tr>
		 		<td>UserName</td>
		 		<td>CellPhoneNo</td>
		 		<td>Email</td>
		 		<td>Name</td>
				 <td>Address</td>
		 		<td>Delete</td>
		 		<td>Update</td>
		 	</tr>
	 	
			<c:forEach var="custs" items="${requestScope.allCustomers}">
			
				<tr>
			 		<td>${custs.username}</td>
			 		<td>${custs.cellphoneno}</td>
			 		<td>${custs.email}</td>
			 		<td>${custs.name}</td>
		  		 	<td>${custs.address}</td>
			 		<td><a href="DeleteCustomerServlet?username=${custs.username}">Delete</a></td>
			 		 
			 		 <td><a href="customer_update.jsp?username=${custs.username}">Update</a></td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
	
	
	
	<form action="AdminSearchByUsername">
			<p>Search By Customer Username: <input type="text" name="searchUsername"/>  <input type="submit" value="Search"/> </p>
	</form>
	
	<p><a href="AdminMainPage.jsp">back to Main Page</a></p>

</body>
</html>