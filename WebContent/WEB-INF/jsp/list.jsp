<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- TODO code for body of this page here -->
<c:set var="total_Products" value="${requestScope.totalProducts}" scope="request"></c:set>
<c:set var="products" value="${requestScope.products}"></c:set>
	
<div class="row">
	<c:forEach var="item" begin="0" items="${products}">
		<div class="item-container col-12 col-md-4">
			<div class="item-image-container">
				<a href='<c:url value="/details/${item.ID}"></c:url>'><img src="${item.src}" width="100%" height="100%"></a>
			</div>
			<div class="item-category">${item.type}</div>
			<div class="item-name">${item.name}</div>
			<div class="item-price">${item.price}$</div>
			<div class="item-description">${item.description}</div>
		</div>
	</c:forEach>
	<div class="pagination d-flex col-12">
				<a href="
					<c:choose>
						<c:when test="${pageNumber == null || pageNumber == 1}"></c:when>
						<c:otherwise><c:url value="?page=${pageNumber-1}"></c:url></c:otherwise>
					</c:choose>
				">&laquo;</a>

				<c:set var="page" value="1" />
				
				<c:forEach var="item" begin="0" end="${totalProducts}"
					step="${maxItemDisplay}">
					<a href='<c:url value="?page=${page}"></c:url>'>${page}</a>
					<c:set var="page" value="${page + 1}" />
				</c:forEach>

				<a href="
				<c:choose>
					<c:when test="${pageNumber + 1 == page}"></c:when>
					<c:when test="${pageNumber == null }"><c:url value='?page=2'></c:url></c:when>
					<c:otherwise><c:url value="?page=${pageNumber+1}"></c:url></c:otherwise>
				</c:choose>
			">&raquo;</a>
	</div>
</div>

