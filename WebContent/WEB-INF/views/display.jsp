<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kavya's shopping site</title>
<style type="text/css">
header#list nav ul li{
list-style:none;
}

a#n  {
    text-decoration:none;
	float: left;
	width: 70px;
	text-align: center;
	height:40px;
	line-height: 40px;
	padding: 0 10px;
	margin: 0 15px;
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
	background-color: pink;
	color: black;
	font-family:arial , verdana, sans-serif;
	}
	a#q  {
    text-decoration:none;
	float: right;
	width: 70px;
	text-align: center;
	height:40px;
	line-height: 40px;
	padding: 0 10px;
	margin: 0 15px;
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
	background-color: pink;
	color: black;
	font-family:arial , verdana, sans-serif;
	}
a#n:HOVER {
	background-color: blue;
	color: white;
}
body{
margin: 50px 50px;
}
</style>
</head>

<body >
WelCome ${customer.name}<br/>
<a  href="edit.html?id=${customer.id}">Edit Profile</a><br/>
<a  href="delete.html?id=${customer.id}">Delete Profile</a><br/>
<a href="logout.html?id=${customer.id}">Logout</a><br/>
<a id="q" href="cart.html?id=${customer.id}">cart</a>
<header id="list">
<nav>
<ul>
<li><a id="n" href="women.html?choice=women">Women's</a></li>
<li><a  id="n" href="women.html?choice=men">Men's</a></li>

</ul>
</nav>
</header>
</body>

</html>