<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Inventory</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
<!-- www -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="cover.css" rel="stylesheet">
</head>


<body class="text-center">
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Inventory</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/">Index</a>
					<!-- changing to test sign up -->
					
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">
			<h1 class="cover-heading">Inventory Below</h1>
			<p class="lead">
				<!-- start of chaos -->
				<!-- list change -->
				
				<!--<c:forEach var="var" items="${list}">
					<c:out value="${var}" />
					<br>
					<br>
				</c:forEach>  -->
				<!-- End -->
				<!-- table try -->
				<c:if test="${list != null }">
					<table class="table">
						<caption>Current Inventory</caption>
						<thead>
							<tr>
								<th scope="col">Manufacturer</th>
								<th scope="col">Date Added to Inventory</th>
								<th scope="col">Kilometers</th>
								<th scope="col">Price</th>
								<th scope="col">Model</th>
								<th scope="col">Car Description</th>
								<th scope="col">Image</th>
								<th scope="col">Year</th>
								<!-- trying to add column for clickable link -->
								<th scope="col">Button</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="item">
								<tr>
									<td><c:out value="${item.manufacturer}" /></td>
									<td><c:out value="${item.dateAddedToInventory}" /></td>
									<td><c:out value="${item.kilometers}" /></td>
									<td><c:out value="${item.price}" /></td>
									<td><c:out value="${item.model}" /></td>
									<td><c:out value="${item.carDescription}" /></td>
									<td><img  height="100px" width="200px" src="<c:out value="${item.pictureUrl}"/>"/></td>

									<!-- <td><c:out value="${item.pictureUrl}" /></td>  -->
									<td><c:out value="${item.year}" /></td>
									<!-- button column addition -->
									
									
									<!--<button type="submit" class="btn btn-primary">See
											Car Details</button>  -->
									<td><a href="car-purchase?carDescription=${item.carDescription}" class="text-info"><button class="myButton">View Details</button></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</c:if>
				<!-- still table try -->

			</p>

			<p class="lead">
				
			</p>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					
				</p>
			</div>
		</footer>
	</div>


</body>

</html>
