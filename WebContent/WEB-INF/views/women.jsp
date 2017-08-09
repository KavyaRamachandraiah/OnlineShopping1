<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
header#list1 nav ul li{
list-style:none;
}
body{
margin: 50px 50px;
}
a#w {
    text-decoration:none;
    float:none;
	width: 70px;
	text-align: center;
	height:40px;
	line-height: 40px;
	padding: 0 10px;
	margin: 0 15px;
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
	background-color: red;
	color: black;
	font-family:arial , verdana, sans-serif;
	}
</style>
</head>

<body >

<% session.setAttribute("choice", request.getParameter("choice"));%>

<jsp:include page="display.jsp"></jsp:include>
<br/><br/>

<header id="list1">
<nav>
<ul>
<c:if test="${choice=='women'}">
<li><a id="w" href="dress.html?cat=dress&&choice=women">Dress's</a></li>
<li><a  id="w" href="womenshoes.html?cat=womenshoes&&choice=women">Women Shoes</a></li>
</c:if>
<c:if test="${choice=='men'}">
<li><a id="w" href="foraml.html?cat=formal&&choice=men">Formal's</a></li>
<li><a  id="w" href="menshoes.html?cat=menshoes&&choice=men">Mens Shoes</a></li>
</c:if>
</ul>
</nav>
</header>

<c:if test="${!empty dressitem }">
<table border="1">
<tr>
<th>Description</th>
<th>Price</th>
</tr>
<c:forEach items="${dressitem}" var="d">
<tr>
<td><c:out value="${d.description }"></c:out>
<td><c:out value="${d.price }"></c:out>
<td><a href="addthisitem.html?itemid=${d.itemid}">ADD</a></td>
</tr>

</c:forEach>
</table>
</c:if>
</body>

</html>