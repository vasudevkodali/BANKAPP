<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title"/></title>
</head>
<body>
<h1>Account Details added as following</h1>
<table>
<tr>
<td><h4><spring:message code="lbl.accountNo"/> </h4></td>
<td>${account.accountNo}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.accountHolderNa"/> </h4></td>
<td>${account.accountHolderName}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.age"/></h4></td>
<td>${account.age}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.adhaarId"/> </h4></td>
<td>${account.adhaarId}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.gender"/> </h4></td>
<td>${account.gender}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.address"/></h4></td>
<td>${account.address}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.dob"/></h4></td>
<td>${account.dateOfBirth}</td>
</tr>
<tr>
<td><h4><spring:message code="lbl.vkCode"/></h4></td>
<td>${account.vkCode}</td>
</tr>
</table>
</body>
</html>