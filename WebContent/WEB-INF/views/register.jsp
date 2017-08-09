<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="add.html">
<table>
<tr>
<td><form:label path="id" >Customer Id:</form:label>
<td><form:input path="id" readonly="true" value="${customer.id }" ></form:input></td>
</tr>
<tr>
<td><form:label path="name" >Customer Name:</form:label>
<td><form:input path="name" value="${ customer.name}"></form:input></td>
</tr>
<tr>
<td><form:label path="password" >Customer Password:</form:label>
<td><form:input path="password" value="${ customer.password}"></form:input></td>
</tr>
<tr>
<td><form:label path="age" >Customer age:</form:label>
<td><form:input path="age" value="${ customer.age}"></form:input></td>
</tr>
<tr>
<td><form:label path="email" >Customer email:</form:label>
<td><form:input path="email" value="${ customer.email}"></form:input></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="register"></td>
</tr>
</table>
</form:form>
</body>
</html>