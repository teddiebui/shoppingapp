<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="header.jsp" />
<main>
	<div class="container">
		<div class="row">
			<!-- SECTION LEFT  -->
			<div class="center col-12 col-xl-9">

				<c:import url="/list">
					<c:param name="maxItemDisplay">${maxItemDisplay}</c:param>
					<c:param name="pageNumber">${pageNumber}</c:param>
				</c:import>
			</div>
			<!-- SECTION RIGHT  -->
		</div>
	</div>
</main>
<c:import url="footer.jsp" />