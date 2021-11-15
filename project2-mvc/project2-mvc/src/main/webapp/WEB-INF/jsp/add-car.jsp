<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Add Car</title>

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
				<h3 class="masthead-brand">Add Car</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/">Home/Index</a> <a
						class="nav-link" href="/inventory">Inventory</a> <a
						class="nav-link" href="/transactions">Transactions</a>
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">

			<!-- Notice the form form stuff -->


			<!-- spring form used -->

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
						<label for="inputKilometers">Kilometers</label>
						<form:input path="kilometers" type="text" class="form-control"
							id="inputKilometers" />
					</div>
					<div class="form-group col-md-6">
						<label for="price">Price</label>
						<form:input path="price" class="form-control" />
					</div>
					<div class="form-group col-md-6">
						<label for="inputModel">Model</label>
						<form:input path="model" type="text" class="form-control"
							id="inputModel" />
					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputCarDescription">Car Description</label>
						<form:input path="carDescription" type="text" class="form-control"
							id="inputCarDescription" />
					</div>
					<div class="form-group col-md-6">
						<label for="inputPictureUrl">Picture Url</label>
						<form:input path="pictureUrl" type="text" class="form-control"
							id="inputPictureUrl" />
					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputYear">Year</label>
						<form:input path="year" type="text" class="form-control"
							id="inputYear" />
					</div>


				</div>

				<button type="submit" class="btn btn-primary">Add Car</button>
			</form:form>
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p></p>
			</div>
		</footer>
	</div>


</body>

</html>


