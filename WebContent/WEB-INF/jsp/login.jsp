<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="modal-login">
	<div class="button-close"><a href='<c:url value="index"/>'>CLOSE</a></div>
	<div class="caption">SIGN IN</div>
	
	<form name="login" method="post" action="login" onsubmit="return validateLogin()">
	<input type="hidden" name="current_url" value='${pageContext.request.requestURI}'>
		<div class="form-142">
			<label for="username">EMAIL:</label> 
			<input id="username" type="text" name="username" placeholder="Enter your email">
		</div>
		<div class="form-142">
			<label for="password">PASSWORD: </label> 
			<input id="password" type="password" name="password" placeholder="Enter your password">
		</div>
		
		<div class="checkbox">
			<input type="checkbox" name="checkbox" value="checked"> Remember me
		</div>
		<div class="submit">
			<input type="submit" value="Next" >
		</div>
	</form>
	<div class="error">${error}</div>
	<c:set var="error" value="" scope="session"></c:set>
	<div class="image-container"><img src="${pageContext.request.contextPath}/resources/image/enjoy.png" width="100%" height="100%" alt="login-banner"></div>
	<div class="forgot"><a href="#">Forgot your password?</a></div>
</div>