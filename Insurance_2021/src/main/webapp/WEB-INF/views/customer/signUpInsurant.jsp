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
								src="img/undraw_profile.svg">
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
						<h1 class="h3 mb-0 text-gray-800">기본 정보 입력하기</h1>
					</div>

					<!-- /.row -->
					<!-- Content Row -->
					<div class="row">

						<div class="col-lg-6 mb-4">
							<form id="form-detailInsurance" action="goToSpecializeRate"
								method="get">
								<!-- Illustrations -->
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">이름</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<label>가입자의 이름을 입력하세요 : </label>
													<div class="col-4">
														<input type="text" class="form-control" id="inputName"
															maxlength='10'>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- Approach -->
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">나이</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<label>가입자의 나이를 입력하세요 : </label>
													<div class="col-2">
														<input type="number" class="form-control" id="inputAge"
															maxlength='4' min='0'>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">주소</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<label>가입자의 거주지 주소를 입력하세요</label>
													<div class="col-10">
														<input type="text" class="form-control" id="inputAddress"
															placeholder="ex) xx도 oo시 / xx시 oo구">
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">전화번호</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="col">
													<label>가입자의 전화번호를 입력하세요 (010-xxxx-xxxx)</label>
													<div class="row">

														<div class="col-2">
															<input type="tel" class="form-control"
																id="inputPhoneNumber1" maxlength='3' pattern="[0-9]{3}">
														</div>
														<p>-</p>
														<div class="col-2">
															<input type="tel" class="form-control"
																id="inputPhoneNumber2" maxlength='4'>
														</div>
														<p>-</p>
														<div class="col-2">
															<input type="tel" class="form-control"
																id="inputPhoneNumber3" maxlength='4'>
														</div>

													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">직업</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="col">
													<label>가입자의 직업을 선택해주세요</label>
													<div class="col">
														<div class="row">
															<div class=form-check>
																<input class="form-check-input" type="radio"
																	name="jobRadio" value="Officer" checked> <label
																	class="form-check-label" for="insuranceRadio1">
																	사무직&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="jobRadio" value=Driver> <label
																	class="form-check-label" for="insuranceRadio2">
																	운전자&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class=form-check>
																<input class="form-check-input" type="radio"
																	name="jobRadio" value="Worker"> <label
																	class="form-check-label" for="insuranceRadio3">
																	현장직&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="insuranceRadio" value="Student"> <label
																	class="form-check-label" for="insuranceRadio4">
																	학생&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
														</div>
														<div class="row">
															<div class=form-check>
																<input class="form-check-input" type="radio"
																	name="jobRadio" value="Teacher" checked> <label
																	class="form-check-label" for="insuranceRadio1">
																	교사&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class="form-check">
																<input class="form-check-input" type="radio"
																	name="jobRadio" value="Soldier"> <label
																	class="form-check-label" for="insuranceRadio2">
																	군인&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
															<div class=form-check>
																<input class="form-check-input" type="radio"
																	name="jobRadio" value="Etc"> <label
																	class="form-check-label" for="insuranceRadio3">
																	기타&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
															</div>
														</div>


													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</form>
							<div class="col">
								<button type="button" class="btn btn-primary"
									onclick="nextBtn()">다음 단계로</button>
							</div>
							<script>
								function nextBtn() {
									$("#form-detailInsurance").submit();
								}
							</script>
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