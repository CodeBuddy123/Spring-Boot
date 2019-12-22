<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red" align="center">Ashish Software Solutions</h2>
<h2 style="color:green" align="center">Student Details</h2>
<table border='1' bgcolor='lightblue' align='center'>
<tr>
	<td>Student ID</td>
	<td>${student.sid}</td>
</tr>
<tr>
	<td>Student Name</td>
	<td>${student.sname}</td>
</tr>
<tr>
	<td>Student Address</td>
	<td>${student.saddr}</td>
</tr>
</table>
<h3 align="center">
<a href="home">|Home|</a>
</h3>
</body>
</html>