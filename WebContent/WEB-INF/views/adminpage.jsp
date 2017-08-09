<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
WelCome Admin!!!
<form:form action="additem.html">
<table>
<tr>
<td><form:label path="itemid">Item ID:</form:label></td>
<td><form:input path="itemid" value="${item.itemid}" readonly="true"></form:input></td>
</tr>
<tr>
<td><form:label path="catogory">Item Catogory:</form:label></td>
<td><form:input path="catogory" value="${item.catogory}" ></form:input></td>
</tr>

<tr>
<td><form:label path="description">Item description:</form:label></td>
<td><form:input path="description" value="${item.description}" ></form:input></td>
</tr>

<tr>
<td><form:label path="price">Item Price:</form:label></td>
<td><form:input path="price" value="${item.price}" ></form:input></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="add"/></td>
</tr>

</table>
</form:form>
<c:if test="${! empty items  }">
<table border="1">
<tr>
<th>Item ID</th>
<th>Item Catogory</th>
<th>Item Description</th>
<th>Item Price</th>
</tr>
<c:forEach items="${items}" var="item">
<tr>
<td><c:out value="${item.itemid}"/></td>
<td><c:out value="${item.catogory}"/></td>
<td><c:out value="${item.description}"/></td>
<td><c:out value="${item.price}"/></td>
<td><a href="/ShoppingProject/edititem.html?itemid=${ item.itemid}">Edit</a>|<a href="/ShoppingProject/deleteitem.html?itemid=${ item.itemid}">Delete</a></td>
</tr>
</c:forEach>
</table>

</c:if>
<form action="adminlogout.html">
<input type="submit" value="Logout">
</form>

</body>
</html>