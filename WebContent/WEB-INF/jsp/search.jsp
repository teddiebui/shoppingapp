<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="header.jsp" />
<c:set var="queryString" value="
&max_item_display=${param.max_item_display}
&keyword=${param.keyword}
&category=${param.category}"></c:set>

<main>
	<div class="container">
		<div class="row">
			<!-- SECTION LEFT  -->
			
			<div class="center col-12 col-xl-9">
				<c:choose>
					<c:when test="${result == null || result != 'not_found'}">
						<c:import url="/SearchController2">
							<c:param name="max_item_display">${param.max_item_display}</c:param>
							<c:param name="current_page">${param.page == null || param.page == 1 ? 1 : param.page}</c:param>
							<c:param name="category">${param.category}</c:param>
							<c:param name="keyword">${param.keyword}</c:param>
						</c:import>
						
						<!-- SECTION BOTTOM  -->
						<div class="pagination d-flex col-12">
				<a
					href="<c:choose>
				<c:when test="${current_page == null || current_page == 1}"></c:when>
				<c:otherwise><c:url value="?page=${current_page-1}${queryString}"></c:url></c:otherwise>
			</c:choose>">&laquo;</a>

				<c:set var="page" value="1" />
				<c:forEach var="item" begin="0" end="${requestScope.maxProduct-1}"
					step="${max_item_display}">
					<a href='<c:url value="?page=${page}${queryString}"></c:url>'>${page}</a>
					<c:set var="page" value="${page + 1}" />
				</c:forEach>

				<a
					href="<c:choose>
				<c:when test="${current_page + 1 == page}">#</c:when>
				<c:otherwise><c:url value="?page=${current_page+1}${queryString}"></c:url></c:otherwise>
			</c:choose>">&raquo;</a>
			</div>
					
					</c:when>
					<c:otherwise>
						<div class="search-error message">Sorry search not found.</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- SECTION RIGHT  -->



		</div>
	</div>


</main>

<!-- end of TODO -->


<c:import url="footer.jsp" />