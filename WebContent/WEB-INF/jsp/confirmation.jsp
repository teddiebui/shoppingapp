<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	
<body>
	<h2>${requestScope.message}</h2>
	<div><p>Your username: ${requestScope.username}</p></div>
	<div><p>URL: ${pageContext.request.contextPath}</p></div>
	<div><p>URL: <c:url value="${pageContext.request.contextPath}"></c:url></p></div>

</body>
</html>