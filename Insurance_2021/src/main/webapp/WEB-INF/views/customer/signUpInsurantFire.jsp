<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>보험사</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css"
	rel="stylesheet">


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	
</script>

</head>

<body id="page-top">


	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
		<symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
			<path
			d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
		</symbol>
		<symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
			<path
			d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
		</symbol>
		<symbol id="exclamation-triangle-fill" fill="currentColor"
			viewBox="0 0 16 16">
			<path
			d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
		</symbol>
	</svg>

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href=#>
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3" id="test"
					onclick="selectInsurance();">
					<h3>송충이들</h3>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="cancerInsurance"> <i class="fas fa-fw fa-pills"></i> <span>암보험</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider my">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="driverInsurance"> <i class="fas fa-fw fa-car"></i> <span>운전자보험</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider my">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="dentalInsurance"> <i class="fas fa-fw fa-tooth"></i> <span>치과보험</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider my">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="fireInsurance"> <i class="fas fa-fw fa-fire"></i> <span>화재보험</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider my">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="tripInsurance"> <i class="fas fa-fw fa-plane"></i> <span>여행자보험</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider my">
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="actualCostInsurance"> <i class="fas fa-fw fa-hospital"></i>
					<span>실비보험</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Insurance</div>

			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>



		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">

					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">안녕하세요
									${customerName} 님!</span> <img class="img-profile rounded-circle"
								src="${pageContext.request.contextPath}/resources/img/undraw_profile.svg">
						</a></li>

						<div class="topbar-divider d-none d-sm-block"></div>


						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href=# id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button" class="btn btn-outline-success"
									onclick="location.href='myPage'">마이페이지</button>
						</a></li>
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button"
									onclick="location.href='selectCancerInsurance/doLogout'"
									class="btn btn-outline-dark">로그아웃</button>
						</a></li>


					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">상세정보 입력하기</h1>
					</div>

					<!-- /.row -->
					<!-- Content Row -->
					<div class="row">

						<div class="col-lg-6 mb-4">
							<form name="formSignUpInsurant"
								action="doRegisterFireInsurance" method="get">

								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary" id="age">공시가</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<label>건물의 공시가를 입력해주세요 : </label>
													<div class="col-2">
														<input type="number" class="form-control"
															name="postedPrice" maxlength='15' min='0'
															onChange="postedPriceChange();">
													</div>
												</div>
											</div>
											<div id="postedPriceAlarm" style="display: none;">
												<div
													class="alert alert-danger d-flex align-items-center mt-3">
													<svg class="bi flex-shrink-0 me-2" width="24" height="24"
														role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
													<div>&nbsp 내용을 입력해주세요!!</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="card shadow mb-4"
									id="checkCancerType">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">건물 용도</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="col">
													<label>건물의 용도를 선택해주세요</label>
													<div class="col">
														<div class="row">
															<div class=form-check>
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="house"> <label
																	class="form-check-label" for="insuranceRadio1">
																	주택&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="study"> <label
																	class="form-check-label" for="insuranceRadio2">
																	교육시설&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="factory"> <label
																	class="form-check-label" for="insuranceRadio2">
																	공장&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="warehouse"> <label
																	class="form-check-label" for="insuranceRadio2">
																	창고&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="office"> <label
																	class="form-check-label" for="insuranceRadio2">
																	사무실&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="usageOfStructure" value="publicFacility"> <label
																	class="form-check-label" for="insuranceRadio2">
																	공공시설&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div id="usageOfStructureAlarm" style="display: none;">
												<div
													class="alert alert-danger d-flex align-items-center mt-3">
													<svg class="bi flex-shrink-0 me-2" width="24" height="24"
														role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
													<div>&nbsp 내용을 입력해주세요!!</div>
												</div>
											</div>

										</div>
									</div>
								</div>
								
								<div class="col">
									<button type="button" class="btn btn-primary"
										onclick="checkInput();">가입 신청하기</button>
								</div>

							</form>
						</div>
					</div>

				</div>

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a classl="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<script>
		function checkInput() {
			form = document.formSignUpInsurant;

			if (form.postedPrice.value == "") {
				$('#postedPriceAlarm').show();
				form.postedPrice.style.borderColor = "red";
			} else if ($(':radio[name="usageOfStructure"]:checked').length < 1) {
				$('#usageOfStructureAlarm').show();
			} else {
				form.submit();
			}
		}

		function postedPriceChange() {
			form.postedPrice.style.borderColor = "#D1D3E2";
			$('#postedPriceAlarm').hide();
		}
		
		$("input:radio[name=usageOfStructure]").click(function() {
			$('#usageOfStructureAlarm').hide();
		});
		
		
	</script>

	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value="resources/vendor/jquery/jquery.min.js" />"></script>
	<script
		src="<c:url value="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="resources/js/sb-admin-2.min.js" />"></script>

	<!-- Page level plugins -->
	<script src="<c:url value="resources/vendor/chart.js/Chart.min.js" />"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value="resources/js/demo/chart-area-demo.js" />"></script>
	<script src="<c:url value="resources/js/demo/chart-pie-demo.js" />"></script>

</body>

</html>