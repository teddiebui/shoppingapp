<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="url"><c:url value="/register_handler"></c:url></c:set>
<div class="modal-register">

	<div class="button-close"><a href="<c:url value="/index"/>">CLOSE</a></div>
	<div class="caption">CREATE YOUR SHOPPING ACCOUNT</div>
	<form:form class="display-block" name="register" method="post" action="${url}" modelAttribute="newAccount" onsubmit="return validateRegister()">
		<input type="hidden" name="current_url" value='${pageContext.request.requestURI}'>
		<div>
			<form:label path="username">Username: </form:label>
			<form:input path="username" placeholder="Enter your email"/>
		</div>
		<div>
			<form:label path="password">password: </form:label>
			<form:input path="password" type="password" placeholder="Enter your password"/>
		</div>
		
		<div>
			<label for="match_password">Re-enter password:</label> <input type="password"
				id="match_password" placeholder="Re-enter your password">
		</div>
		
		<div>
			<form:label path="address">Address: </form:label>
			<form:input path="address" placeholder="Your address"/>
		</div>
		<div>
			<form:label path="phoneNumber">Phone number: </form:label>
			<form:input path="phoneNumber" placeholder="Ex: +84 97 73 07843"/>
		</div>
		<div class="submit">
			<input type="submit" value="Next">
		</div>
	</form:form>
	
	<div class="success">${success}</div>
	<div class="error">${error}</div>
	
	<c:set var="success" value="" scope="request"></c:set>
	<c:set var="error" value="" scope="request"></c:set>
</div>
