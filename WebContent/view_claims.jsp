<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DBHelper.QueryClaimsByUsername" %>
<%@ page import="Entity.Claim" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Claims</title>
</head>
<%


QueryClaimsByUsername queryClaims = new QueryClaimsByUsername();

String username = (String)request.getSession().getAttribute("username");

System.out.println(username);
List<Claim> cust_claims = queryClaims.doRead(username);

%>

<body>
    <h1>Open Claims</h1>
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
	 	
			<c:forEach var="claim" items="<%=cust_claims%>">
			
				<tr>
			 		<td>${claim.claimid}</td>
			 		<td>${claim.purchaseid}</td>
			 		<td>${claim.username}</td>
			 		<td>${claim.dateofclaim}</td>
			 		<td>${claim.description}</td>
			 		<td>${claim.status}</td>
			 	</tr>
			</c:forEach>
		</table>
	</p>
	
	<a href="QueryRegisteredProductByCustomer">Go Back</a> 
	
	

</html>