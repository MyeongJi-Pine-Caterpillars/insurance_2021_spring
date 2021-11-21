<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!doctype html>
<html lang>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="http://localhost:8081/controller/cancerInsurance"><h2>|암보험&nbsp;&nbsp;&nbsp;</h2></a>
			<a class="navbar-brand" href="http://localhost:8081/controller/dentalInsurance"><h2>|치과보험&nbsp;&nbsp;&nbsp;</h2></a>
			<a class="navbar-brand" href="http://localhost:8081/controller/driverInsurance"><h2>|운전자보험&nbsp;&nbsp;&nbsp;</h2></a>
			<a class="navbar-brand" href="http://localhost:8081/controller/fireInsurance"><h2>|화재보험&nbsp;&nbsp;&nbsp;</h2></a>
			<a class="navbar-brand" href=#><h2><p class="text-success">|여행자보험&nbsp;&nbsp;&nbsp;</p></h2></a>
			<a class="navbar-brand" href="http://localhost:8081/controller/actualInsurance"><h2>|실비보험&nbsp;&nbsp;&nbsp;</h2></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				</ul>
				<form class="d-flex">
					<h5>안녕하세요 ${clientName} 님!</h5>
					&nbsp;&nbsp;&nbsp;
					<button class="btn btn-outline-success" type="submit">마이페이지</button>
					&nbsp;&nbsp;
					<button class="btn btn-outline-dark" type="submit">로그아웃</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>