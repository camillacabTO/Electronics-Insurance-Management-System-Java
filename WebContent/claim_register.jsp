<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Claims </title>
</head>

<body>
<fieldset style="display: inline-block;">
<h2>Open Claim</h2>
    <form action="AddClaimServlet" method="post">
    	<input type="hidden" value="${param.id}" name="purchaseid"/>
    	<input type="hidden" value="${param.username}" name="username"/>
        Date of Claim: <input type="text" name="dateofclaim"><br><br>
        Description: <textarea name="description"cols="30" rows="10"></textarea><br><br>
        <input type="submit" value="Submit">
    </form>
</fieldset>
</html>