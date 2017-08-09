<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
WelCome ${customer.name}<br/>
<a  href="edit.html?id=${customer.id}">Edit Profile</a><br/>
<a  href="delete.html?id=${customer.id}">Delete Profile</a><br/>
<a href="logout.html?id=${customer.id}">Logout</a><br/>
<br/>
<br/>
<br/>
<br/>
<a href="display.html">ContinueShopping</a>
</body>
</html>