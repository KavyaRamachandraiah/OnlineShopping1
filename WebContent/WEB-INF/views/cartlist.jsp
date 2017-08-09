<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a#k{
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
	background-color: green;
	color: black;
	font-family:arial , verdana, sans-serif;
}
a#k1{
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
	background-color: green;
	color: black;
	font-family:arial , verdana, sans-serif;
}

</style>
</head>
<body>
WelCome ${customer.name}<br/>
<a  href="edit.html?id=${customer.id}">Edit Profile</a><br/>
<a  href="delete.html?id=${customer.id}">Delete Profile</a><br/>
<a href="logout.html?id=${customer.id}">Logout</a><br/>
<c:if test="${!empty purchaselist }">
<table border="1">
<tr>
<th>Puchase Id</th>
<th>Purchase Itemid</th>
<th>Puchase Catogory</th>
<th>Purchase Description</th>
<th>Purchase Price</th>

</tr>
<c:forEach items="${purchaselist}" var="e">
<tr>
<td><c:out value="${e.pid}"/></td>
<td><c:out value="${e.itemid}"/></td>
<td><c:out value="${e.catogory}"/></td>
<td><c:out value="${e.description}"/></td>
<td><c:out value="${e.price}"/></td>
<td><a href="remove.html?pid=${e.pid}">remove</a></td>
</tr>
</c:forEach>
<tr>
<td>Total</td>
<td>${total}</td>
</tr>
</table>
<a id ="k" href="display.html">Continue Shopping</a><a id="k1" href="checkout.html">Checkout</a>
</c:if>

<c:if test="${empty purchaselist }">
Cart is Empty!!
<a id ="k" href="display.html">Continue Shopping</a>
</c:if>

</body>
</html>