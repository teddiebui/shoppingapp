<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

THANK YOU FOR YOUR PURCHASE<br>
cart: ${sessionScope.cart}<br>
cart items: ${sessionScope.cart.items }<br>
<a href='<c:url value="index.jsp"></c:url>'>CONTINUE SHOPPING</a>
</body>
</html>