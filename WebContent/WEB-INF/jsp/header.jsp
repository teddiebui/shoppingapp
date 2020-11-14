<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mobile.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/desktop.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/register.css">
<script src="https://kit.fontawesome.com/f6ac6d4ab1.js"
	crossorigin="anonymous"></script>
<title>IPHONE SHOP</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<!-- TODO: add login or register page -->


<c:choose>
	<c:when test="${param.action == 'login'}">
		<c:import url="login.jsp" />
	</c:when>

	<c:when test="${param.action == 'register'}">
		<c:import url="register.jsp" />
	</c:when>
</c:choose>

<!-- end -->

<!-- - Some other param -->
<c:set var="maxItemDisplay" value="6" scope="request"></c:set>
<c:set var="pageNumber" value="${param.page == null ? 1 : param.page}" scope="request"></c:set>

<header>
	<div class="container">
		<div class="d-flex justify-content-between row">
			<div class="col-md-3 logo">
				<span>PRJ311X</span> <span>WELCOME TO MY PROJECT</span>
			</div>
			<div class="col-md-7 search">
				<form name="search" action='<c:url value="/search.jsp"></c:url>'
					method="get" class="d-flex">
					<input type="hidden" name="current_page" value="${current_page}">
					<input type="hidden" name="max_item_display"
						value="${max_item_display}"> <select name="category"
						id="category">
						<option value="all">All</option>
						<c:forEach var="item" items="${results.rows}">
							<option value="${item.type}">${item.type}</option>
						</c:forEach>
					</select> <input type="search" name="keyword" class="flex-grow-1">
					<button type="submit">
						<i class="fas fa-search"></i>SEARCH
					</button>
				</form>
			</div>
			<div class="col-6 col-md-1 cart">
				<a href='<c:url value="cart.jsp"></c:url>'> <i
					class="fas fa-shopping-cart"></i></a>
				<div class="cart-info">
					Your Cart has:
					<c:out value="${sessionScope.cart.totalItems}"></c:out>
					items
				</div>
			</div>
			<div class="col-6 col-md-1 purchase">
				<a href='<c:url value="cart.jsp"></c:url>'>PURCHASE</a>
			</div>

		</div>
	</div>
</header>
<div class="topnav">
	<div class="container">
		<ul class="d-md-flex justify-content-between">
			<li><a href='<c:url value="index.jsp"></c:url>'>HOME</a></li>
			<li><a href="#">PRODUCT</a></li>
			<li><a href="#">ABOUT</a></li>
			<c:choose>
				<c:when test="${sessionScope.account == null}">
					<li id="ig-577"><a href='?action=login&${pageContext.request.queryString}'>SIGN IN</a></li>
					<li><a href="register">REGISTER</a></li>
				</c:when>
				<c:otherwise>
					<li id="ig-577"><a href='logout'>SIGN OUT</a></li>
					
				</c:otherwise>

			</c:choose>
			
		</ul>
	</div>
</div>
<!--  TODO code header here -->




<!--  end of TODO -->