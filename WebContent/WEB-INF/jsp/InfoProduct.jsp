<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="header.jsp" />

<!-- TODO code for body of this page here -->
<main>
	<div class="container">
		<div class="item-details-container row">
			<div class="product_img col-6">
				<img src="${product.src}" width="100%" height="100%">
			</div>
			<div class="item-details col-6">
				<div class="item-category">${product.type}</div>
				<div class="item-name">${product.name}</div>
				<div class="item-price">${product.price}$</div>
				<div class="item-description">${product.description}</div>
				<div class="add-cart"><a href='<c:url value="/cart?action=add&ID=${product.ID}"></c:url>'><i class="fas fa-shopping-cart"></i> ADD TO CART</a></div>
			</div>
		</div>
	</div>
</main>


<!-- end of TODO -->


<c:import url="footer.jsp" />