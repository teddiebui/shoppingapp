<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/admin.css">
<script src="https://kit.fontawesome.com/f6ac6d4ab1.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<header>
		<div class="position-relative">
			<ul class="topnav d-flex align-items-center position-absolute">
				<li>Welcome back, <%=session.getAttribute("user") == null ? "null" : session.getAttribute("user")%></li>
				<li><i class="fas fa-cogs"></i><a href="#">Preferences</a></li>
				<li><i class="fas fa-flag"></i><a href="#">Language</a></li>
				<li><i class="fas fa-undo-alt"></i><a href="<%= response.encodeURL(request.getContextPath()+"/login?action=logout")%>">Log out</a></li>
			</ul>
		</div>
	</header>
	<main >
		<div class="row flex-nowrap">
			<div class="col-1 left" id="left">
				<div class="background-image"></div>
				<div class="header">
					<h3>1849 TEAM</h3>
				</div>
				<ul class="d-flex flex-column">
					<li><i class="fas fa-th-large"></i><a href="#">Dashboard</a></li>
					<li><i class="fas fa-users"></i><a href="#">Staff Manager</a></li>
					<li><i class="fas fa-chart-line"></i><a href="#">Analysis</a></li>

					<li><i class="fas fa-wrench"></i><a href="#">Settings </a></li>
				</ul>
			</div>
			<div class="col-11 right" id="right">
				<div class="background-img">
					<img src="image/2.jpg" atl="hey" width="100%" height="100%">
				</div>
				<div class="main-content">
					<table class="myTable">
						<thead>
							<tr>
								<th>Column 1</th>
								<th>Column 1</th>
								<th>Column 1</th>
								<th>Column 1</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Data 1</td>
								<td>Data 2</td>
								<td>Data 3</td>
								<td>Data 4</td>
							</tr>
							<tr>
								<td>Data 1</td>
								<td>Data 2</td>
								<td>Data 3</td>
								<td>Data 4</td>
							</tr>
							<tr>
								<td>Data 1</td>
								<td>Data 2</td>
								<td>Data 3</td>
								<td>Data 4</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<footer></footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

</body>
</html>