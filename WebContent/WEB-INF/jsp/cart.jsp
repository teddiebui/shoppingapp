<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="header.jsp"></c:import>


<main>
	<div class="d-flex flex-column">
		<c:choose>
			<c:when test="${fn:length(sessionScope.cart.items) > 0}">
				<c:forEach var="item" items="${sessionScope.cart.items}">
					<div class="cart-item-container container">
						<div class="row">
							<div class="col-6 col-md-5 col-lg-2 item-image-container">
								<img src="${item.src}" width="100%" height="100%">
							</div>
							<div class="col-6 col-md-7 col-lg-10 ig754 container">
								<div class="row">
									<div class="col-12 col-lg-6">
										<div class="item-category">${item.type}</div>
										<div class="item-name">${item.name}</div>
										<div class="item-description">${item.description}</div>
										<div class="item-price">${item.price}$</div>
									</div>
									<div class="col-12 col-lg-3">
										<div class="cart-item-quantity d-flex">
											<a class="item-decrement" href="#">-</a> <span>Quantity:
												${item.number}</span> <a class="item-increment" href="#">+</a>
										</div>
									</div>
									<div class="col-12 col-lg-2 cart-item-total-price">Total:
										${item.number * item.price}$</div>
									<div class="col-12 col-lg-1 item-remove">
										<a
											href='<c:url value="/AddToCartController?action=delete&ID=${item.ID}"></c:url>'>Remove</a>
									</div>
								</div>

							</div>


						</div>
					</div>

				</c:forEach>
				<div  class="container" id="ig546" >
					<div class="row">
						<div class="col-12 cart-grant-total">GRAND TOTAL:${sessionScope.cart.amount}$</div>
				<div class="col-12 button purchase">
<a href='<c:choose>
			<c:when test="${sessionScope.account == null}">
				<c:url value="?action=login"></c:url>
				</c:when>
			<c:otherwise>
				<c:url value="/PayController"></c:url>
			</c:otherwise>
		</c:choose>'>BUY
						NOW</a>
				</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="cart-no-item container">
					<div class="message">YOUR CART IS EMPTY</div>
					<div class="">
						<a href='<c:url value="index.jsp"></c:url>' class="button">CONTINUE
							SHOPPING</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</main>

<c:import url="footer.jsp"></c:import>