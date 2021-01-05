<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Claims</title>
</head>
<body>


 <h1>Show All Claims</h1>
    	<p> 
	 	<table border = 1px>
		 	<tr>
		 		<td>ClaimID</td>
		 		<td>PurchaseID</td>
		 		<td>Username</td>
		 		<td>Date of Claim</td>
		 		<td>Description</td>
		 		<td>Status</td>
		 	</tr>
	 	
			<c:forEach var="claim" items="${requestScope.claims }">
			
				<tr>
			 		<td>${claim.claimid}</td>
			 		<td>${claim.purchaseid}</td>
			 		<td>${claim.username}</td>
			 		<td>${claim.dateofclaim}</td>
			 		<td>${claim.description}</td>
			 		<td><a href="AdminChangeClaimStatus?claimid=${claim.claimid}"/>${claim.status}</td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
	
	<a href="AdminMainPage.jsp">Go Back</a> 
	
	
	
</body>
</html>