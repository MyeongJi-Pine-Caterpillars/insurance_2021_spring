<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.insurance.sce.global.Constants.eInsuranceType"%>

<%
List<Map<String, Object>> mapList = (List<Map<String, Object>>) request.getAttribute("mapList");
%>


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
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					<h3>송충이들</h3>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="cancerInsurance"> <i class="fas fa-fw fa-list"></i> <span>가입한
						보험 리스트</span></a></li>

			<hr class="sidebar-divider my">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href=#> <i
					class="fas fa-fw fa-book"></i> <span>보험 부활 신청</span></a></li>

			<hr class="sidebar-divider my">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href=#> <i
					class="fas fa-fw fa-handshake"></i> <span>면담신청</span></a></li>

			<hr class="sidebar-divider my">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href=#> <i
					class="fas fa-fw fa-check-square"></i> <span>고객만족도 설문조사</span></a></li>

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
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button" class="btn btn-outline-success"
									onClick="location.href='cancerInsurance'">보험 리스트 보기</button>
						</a></li>
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button" class="btn btn-outline-dark"
									onclick="location.href='myPage/doLogout'">로그아웃</button>
						</a></li>


					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">마이페이지</h1>
					</div>


					<br>
					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">가입한 보험 리스트</h6>
								</div>
								<div class="card-body">
									<div class="row">
										<table class="table table-bordered table-hover" id="dataTable"
											width="100%">
											<thead>
												<tr>
													<th>계약 ID</th>
													<th>보험 이름</th>
													<th>보험 종류</th>
													<th>보험료</th>
													<th>가입자 이름</th>
												</tr>
											</thead>

											<tbody>

												<%
												for (Map<String, Object> map : mapList) {
												%>
												<tr>
													<td><%=(String) map.get("contractId")%></td>
													<td><%=(String) map.get("insuranceName")%></td>
													<td><%=(String) eInsuranceType.get((Integer) map.get("type")).getNameKor()%></td>
													<td><%=(Integer) map.get("fee")%></td>
													<td><%=(String) map.get("insurantName")%></td>
													<td style="display: none"><%=(String) map.get("insuranceId")%></td>
												</tr>
												<%
												} ;
												%>

											</tbody>
										</table>

									</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">가입자 정보</h6>
								</div>
								<div class="card-body">
									<div class="row" style="display: none" id="insurantCard">
										<div class="col-3" style="display: none" id="man">
											<img
												src="${pageContext.request.contextPath}/resources/img/undraw_profile_2.svg"
												class="img-thumbnail">
										</div>
										<div class="col-3" style="display: none" id="woman">
											<img
												src="${pageContext.request.contextPath}/resources/img/undraw_profile_3.svg"
												class="img-thumbnail">
										</div>

										<div class="col">
											<div class="row mb-3 mt-4">
												<div class="col">
													<h5 id="name">이름 :</h5>
												</div>
												<div class="col">
													<h5 id="gender">성별 :</h5>
												</div>
												<div class="col">
													<h5 id="age">나이 :</h5>
												</div>
											</div>
											
											<div class="row mb-3 mt-3">
												<div class="col-md-4">
													<h5 id="job">직업 :</h5>
												</div>
												<div class="col-md-8">
													<h5 id="address">주소 :</h5>
												</div>
											</div>

											<div class="row mb-3 mt-3">
												<div class="col">
													<h5 id="phoneNumber">전화번호 :</h5>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>

							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">보장내역</h6>
								</div>

								<div class="card-body">
									기본계약
									<ol class="list-group list-group-numbered" id="guaranteePlan"></ol>
									선택특약
									<ol class="list-group list-group-numbered"
										id="guaranteePlanSpecial"></ol>
								</div>
							</div>

						</div>

						<div class="col-lg-6 mb-4"></div>
					</div>

				</div>
				<!-- /.container-fluid -->

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
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<div id="ajax_indicator" style="display: none;">
		<p
			style="text-align: center; padding: 16px 0 0 0; left: 50%; top: 50%; position: absolute;">
			<img
				src="${pageContext.request.contextPath}/resources/img/loading.gif" />
		</p>
	</div>

	<script>
		$("#dataTable tr")
				.click(
						function() {
							var tr = $(this);
							var td = tr.children();

							var contractId = {
								"contractId" : td.eq(0).text()
							};
							var insuranceId = {
								"insuranceId" : td.eq(5).text()
							};
							var type = td.eq(2).text();

							$
									.ajax({
										url : "myPage/doSelectGuaranteePlan",
										type : "GET",
										data : insuranceId,

										beforeSend : function() {
											$('#ajax_indicator').show().fadeIn(
													'fast');
										},
										complete : function() {
											$('#ajax_indicator').fadeOut();
										},

										success : function(data) {
											$('#guaranteePlan')
													.html(
															'<ol class="list-group list-group-numbered" id="guaranteePlan"></ol>');
											$
													.each(
															data,
															function(index,
																	item) {
																if (!item.special) {
																	if (type == "화재보험"
																			|| type == "운전자보험") {
																		$(
																				'#guaranteePlan')
																				.append(
																						'<li class="list-group-item d-flex justify-content-between align-items-start">'
																								+ '<div class="ms-2 me-auto"><div class="fw-bold">'
																								+ item.content
																								+ '</div>보장금액 : '
																								+ item.compensation
																								+ '원<br>보장비율 : '
																								+ item.rate
																								* 100
																								+ '%</li>');
																	} else {
																		$(
																				'#guaranteePlan')
																				.append(
																						'<li class="list-group-item d-flex justify-content-between align-items-start">'
																								+ '<div class="ms-2 me-auto"><div class="fw-bold">'
																								+ item.content
																								+ '</div>보장금액 : '
																								+ item.compensation
																								+ '원</li>');
																	}
																}
															});
											$('#guaranteePlanSpecial')
													.html(
															'<ol class="list-group list-group-numbered" id="guaranteePlanSpecial"></ol>');
											$
													.each(
															data,
															function(index,
																	item) {
																if (item.special) {
																	if (type == "화재보험"
																			|| type == "운전자보험") {
																		$(
																				'#guaranteePlanSpecial')
																				.append(
																						'<li class="list-group-item d-flex justify-content-between align-items-start">'
																								+ '<div class="ms-2 me-auto"><div class="fw-bold">'
																								+ item.content
																								+ '</div>보장금액 : '
																								+ item.compensation
																								+ '원<br>보장비율 : '
																								+ item.rate
																								* 100
																								+ '%</li>');
																	} else {
																		$(
																				'#guaranteePlanSpecial')
																				.append(
																						'<li class="list-group-item d-flex justify-content-between align-items-start">'
																								+ '<div class="ms-2 me-auto"><div class="fw-bold">'
																								+ item.content
																								+ '</div>보장금액 : '
																								+ item.compensation
																								+ '원</li>');
																	}
																}
															});
										},
										error : function() {
											alert("request error in guaranteePlan!");
										}
									});

							$('#insurantCard').show();
							$.ajax({
								url : "myPage/doSelectInsurant",
								type : "GET",
								data : contractId,

								success : function(data) {
									$('#name').text("이름 : " + data.insurantName);
									$('#phoneNumber').text("전화번호 : " + data.phoneNumber);
									$('#address').text("주소 : " + data.address);
									$('#age').text("나이 : " + data.age);
									$('#gender').text("성별 : " + data.gender);
									$('#job').text("직업 : " + data.job);
									if (data.gender == "남성") {
										$('#man').show();
										$('#woman').hide();
									} else {
										$('#man').hide();
										$('#woman').show();
									}

								},
								error : function(request, status, error) {
									alert("code:" + request.status + "\n"
											+ "message:" + request.responseText
											+ "\n" + "error:" + error);
								}
							});
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