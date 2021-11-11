<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Car Details</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
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
				<h3 class="masthead-brand">Car Purchase</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/index">Home/Index</a> <a
						class="nav-link" href="/inventory">Inventory</a> <a
						class="nav-link" href="#">Contact</a>
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">

			<!-- new stuff -->
			<h1 class="cover-heading">Car Details</h1>
			<p class="lead">Thank you picture ${car.pictureUrl} <br>
			<img  height="100px" width="200px" src="${car.pictureUrl}"><br>
				${car.manufacturer} <br>
				${car.dateAddedToInventory}<br>
				${car.kilometers} <br>
				${car.price} <br>
				${car.model} <br>
				${car.carDescription} <br>
				${car.year} <br>
				for signing up for this test page.</p>

			<!-- Notice the form form stuff -->

			<form:form method="post" action="/add-car" modelAttribute="car">

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputManufacturer">Manufacturer</label>
						<form:input path="manufacturer" type="text" class="form-control"
							id="inputManufacturer" />
					</div>

				</div>


				<!-- May need to change col-md-6 since 3 in row -->
				<div class="form-row">

					<div class="form-group col-md-6">
						<label for="price">Price</label>
						<form:input path="price" class="form-control" />
					</div>

				</div>




				<div class="form-group">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck" />
						<label class="form-check-label" for="gridCheck"> Check me
							out </label>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Buy Car</button>
			</form:form>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>
				</p>
			</div>
		</footer>
	</div>


</body>

</html>


