<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ page import="java.util.List"%>
<%@ page import="com.insurance.sce.model.insurance.Insurance"%>
<%
	List<Insurance> insuranceList = (List<Insurance>)request.getAttribute("insuranceList");
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

<title>SB Admin 2 - Dashboard</title>

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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
					SB Admin <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active">
               	 <a class="nav-link" href="developInsurance.do">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>보험 설계하기</span></a>
            </li>
             <li class="nav-item active">
               	 <a class="nav-link" href="postManageInsurance.do">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>보험 사후관리하기</span></a>
            </li>
			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Interface</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Components</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Components:</h6>
						<a class="collapse-item" href="buttons.html">Buttons</a> <a
							class="collapse-item" href="cards.html">Cards</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Utilities</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Custom Utilities:</h6>
						<a class="collapse-item" href="utilities-color.html">Colors</a> <a
							class="collapse-item" href="utilities-border.html">Borders</a> <a
							class="collapse-item" href="utilities-animation.html">Animations</a>
						<a class="collapse-item" href="utilities-other.html">Other</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Addons</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Test</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="login.html">Login</a> <a
							class="collapse-item" href="register.html">Register</a> <a
							class="collapse-item" href="forgot-password.html">Forgot
							Password</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">Other Pages:</h6>
						<a class="collapse-item" href="404.html">404 Page</a> <a
							class="collapse-item" href="blank.html">Blank Page</a>
					</div>
				</div></li>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link" href="tables.html">
					<i class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

			<!-- Sidebar Message -->
			<!--  <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">
                <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
            </div> -->

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
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
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

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<!--  <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="...">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="...">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a> -->
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="...">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
							<!-- <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a> --> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div>
						</li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">복구 가능한 보험 리스트</h1>
					</div>

					<!-- Content Row -->
					<div class="row">

						<%for(Insurance insurance : insuranceList){ 
						if(insurance.isDel()) {%>
						<div class="col-xl-3 col-md-6 mb-4" id=<%=insurance.getInsuranceId() %>>
							<div class="cardInsurance border-left-primary shadow h-100 py-2">
								<div class="card-body" id=<%=insurance.getInsuranceId() %>>
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="h7 mb-0 font-weight-bold text-primary text-uppercase mb-0">
												ID.
												<%=insurance.getInsuranceId() %></div>
											<div
												class="h5 mb-0 font-weight-bold text-primary text-uppercase mb-3">
												<%=insurance.getName() %></div>
											<div class="h6 mb-0 font-weight-bold text-gray-800">기본
												보험료</div>
											<div class="h6 mb-0 font-weight-bold text-gray-800"><%=insurance.getBasicFee() %>원
											</div>
										</div>
										<div class="col-auto"></div>
									</div>
								</div>
							</div>
						</div>
						<%}
					}; %>

					</div>
					<form id="form-restoreInsurance" action="restoreInsurance/restore" method="get">
						<input style="display:none" class="form-check-input" type="text"
												name="restoreInsuranceId" id="restoreInsuranceId">
					</form>

					<br>
					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">요율</h6>
								</div>
								 <div class="card-body">
									<div class="row">
										<div class="col mb-3" id="rateOfAge"></div>
										<div class="col" id="rateOfJob"></div>
									</div>
									<div class="row">
										<div class="col mb-3" id="rateOfGender"></div>
										<div class="col"></div>
									</div>
									<div class="row">
										<div class="col" id="rateOfFamilyMedicalDiseaseBox"></div>
										<div class="col" id="rateOfFamilyMedicalRelationshipBox"></div>
									</div>
									<div class="row">
										<div class="col" id="rateOfCountryRiskBox"></div>
										<div class="col"></div>
									</div>
									<div class="row">
										<div class="col" id="annualLimitCountBox"></div>
										<div class="col"></div>
									</div>
									<div class="row">
										<div class="col" id="rateOfAccidentHistoryBox"></div>
										<div class="col"></div>
									</div>
									<div class="row">
										<div class="col" id="rateOfCarTypeBox"></div>
										<div class="col" id="rateOfCarRankBox"></div>
									</div>
									<div class="row">
										<div class="col" id="rateOfPostedPriceBox"></div>
										<div class="col" id="rateOfStructureUsageBox"></div>
									</div>
									</div>
							</div>
						</div>


						<div class="col-lg-6 mb-4">

							<!-- Illustrations -->
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
					</div>

					<div class="col">
						<div class="col-lg-6 mb-4">
							<button type="button" class="btn btn-primary btn-lg" onclick="restore()">보험 복구하기</button>
						</div>
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

	<script>
		var ages = ["영유아", "10대", "20대", "30대", "40대", "50대", "노년층"];
		var jobs = ["사무직", "운송업", "현장직", "학생", "교육직", "군인", "기타"];
		var gender = ["남성", "여성"];
		var familyMedicalDisease = ["갑상선암", "고환암", "난소암", "식도암", "폐암"];
		var familyMedicalRelationship = ["1촌", "2촌", "3촌", "4촌"];
		var accidentHistory = ["0회", "1회", "2회~3회", "4회~5회", "6회~7회", "8회 이상"];
		var typeOfCar = ["버스", "승합차", "SUV", "외제차", "기타"];
		var rankOfCar = ["최고급", "고급", "보급형", "저가"];
		var postedPrice = ["(공시가)<=5천만원", "5천만원<(공시가)<=5억", "5억<(공시가)<=10억", "10억<(공시가)<=20억", "20억<(공시가)"];
		var usageOfStructure = ["주택", "교육", "공장", "창고", "사무", "공공시설"];
		var riskOfCountry = ["안전", "1단계", "2단계", "3단계"];
		var annualLimitCount = "연간 한도 횟수";
		var insuranceId = 0;
		function restore(){
			$('#restoreInsuranceId').val(insuranceId);
			if(insuranceId == 0) alert("복구할 보험을 선택해주세요.");
			else {
				alert("보험 복구가 요청되었습니다.")
				$("#form-restoreInsurance").submit();
			}
		}
		$('.col-xl-3').click(function(){
			$('#rateOfFamilyMedicalDiseaseBox').empty();
			$('#rateOfFamilyMedicalRelationshipBox').empty();
			$('#rateOfAccidentHistoryBox').empty();
			$('#rateOfCarTypeBox').empty();
			$('#rateOfCarRankBox').empty();
			$('#annualLimitCountBox').empty();
			$('#rateOfPostedPriceBox').empty();
			$('#rateOfStructureUsageBox').empty();
			$('#rateOfCountryRiskBox').empty();
			insuranceId = {"insuranceId" : $(this).attr('id')};
			$.ajax({
			url: "restoreInsurance/doSelect",
			type: "GET",
			data: insuranceId,
					
			success : function(data){
				insuranceId = data.insuranceId;
				$('#rateOfAge').html('<div class="col mb-3" id="rateOfAge"><h4 class="small font-weight-bold">--나이 요율표--</h4></div>');
				$.each(data.rateOfAge, function(index, item){
					$('#rateOfAge').append(
							'<h4 class="small font-weight-bold">'+ ages[index] +'<span class="float-right">' +
								item +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				});
				$('#rateOfJob').html('<div class="col mb-3" id="rateOfJob"><h4 class="small font-weight-bold">--직업 요율표--</h4></div>');
				$.each(data.rateOfJob, function(index, item){
					$('#rateOfJob').append(
							'<h4 class="small font-weight-bold">'+ jobs[index] +'<span class="float-right">' +
								item +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				});
				$('#rateOfGender').html('<div class="col mb-3" id="rateOfGender"><h4 class="small font-weight-bold">--성별 요율표--</h4></div>');
				$.each(data.rateOfGender, function(index, item){
					$('#rateOfGender').append(
							'<h4 class="small font-weight-bold">'+ gender[index] +'<span class="float-right">' +
								item +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				});
				if(data.type == 1) {
					$('#rateOfAccidentHistoryBox').html('<div class="col mb-3" id="rateOfAccidentHistory"><h4 class="small font-weight-bold">--사고 횟수 요율표--</h4></div>');
					$.each(data.rateOfAccidentHistory, function(index, item){
						$('#rateOfAccidentHistory').append(
								'<h4 class="small font-weight-bold">'+ accidentHistory[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
					$('#rateOfCarTypeBox').html('<div class="col mb-3" id="rateOfCarType"><h4 class="small font-weight-bold">--차 종류 요율표--</h4></div>');
					$.each(data.rateOfCarType, function(index, item){
						$('#rateOfCarType').append(
								'<h4 class="small font-weight-bold">'+ typeOfCar[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
					$('#rateOfCarRankBox').html('<div class="col mb-3" id="rateOfCarRank"><h4 class="small font-weight-bold">--차 등급 요율표--</h4></div>');
					$.each(data.rateOfCarRank, function(index, item){
						$('#rateOfCarRank').append(
								'<h4 class="small font-weight-bold">'+ rankOfCar[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
				} else if(data.type == 2){
					$('#annualLimitCountBox').append(
							'<h4 class="small font-weight-bold">'+ annualLimitCount +'<span class="float-right">' +
								data.annualLimitCount +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				} else if(data.type == 3){
					
				} else if(data.type == 4){
					$('#rateOfPostedPriceBox').html('<div class="col mb-3" id="rateOfPostedPrice"><h4 class="small font-weight-bold">--공시 가격 요율표--</h4></div>');
					$.each(data.rateOfPostedPrice, function(index, item){
						$('#rateOfPostedPrice').append(
								'<h4 class="small font-weight-bold">'+ postedPrice[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
					$('#rateOfStructureUsageBox').html('<div class="col mb-3" id="rateOfStructureUsage"><h4 class="small font-weight-bold">--건물 용도 요율표--</h4></div>');
					$.each(data.rateOfStructureUsage, function(index, item){
						$('#rateOfStructureUsage').append(
								'<h4 class="small font-weight-bold">'+ usageOfStructure[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
					
				} else if(data.type == 5){
					$('#rateOfFamilyMedicalDiseaseBox').html('<div class="col mb-3" id="rateOfFamilyMedicalDisease"><h4 class="small font-weight-bold">--가족병력 요율표--</h4></div>');
					$.each(data.rateOfFamilyMedicalDisease, function(index, item){
						$('#rateOfFamilyMedicalDisease').append(
								'<h4 class="small font-weight-bold">'+ familyMedicalDisease[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
					$('#rateOfFamilyMedicalRelationshipBox').html('<div class="col mb-3" id="rateOfFamilyMedicalRelationship"><h4 class="small font-weight-bold">--병력 가족 관계 요율표--</h4></div>');
					$.each(data.rateOfFamilyMedicalRelationship, function(index, item){
						$('#rateOfFamilyMedicalRelationship').append(
								'<h4 class="small font-weight-bold">'+ familyMedicalRelationship[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
				} else if(data.type == 6){
					$('#rateOfCountryRiskBox').html('<div class="col mb-3" id="rateOfCountryRisk"><h4 class="small font-weight-bold">--여행지 위험 단계 요율표--</h4></div>');
					$.each(data.rateOfCountryRank, function(index, item){
						$('#rateOfCountryRisk').append(
								'<h4 class="small font-weight-bold">'+ riskOfCountry[index] +'<span class="float-right">' +
									item +
									'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
						);
					});
				}
				
			},
			error :function(){
				alert("request error!");
			}
			});

			$.ajax({
			url: "restoreInsurance/doSelectGuaranteePlan",
			type: "GET",
			data: insuranceId,
					
			success : function(data){
				$('#guaranteePlan').html('<ol class="list-group list-group-numbered" id="guaranteePlan"></ol>');
				$.each(data, function(index, item){
					if(!item.special){
						$('#guaranteePlan').append(
							'<li class="list-group-item d-flex justify-content-between align-items-start">' +
								'<div class="ms-2 me-auto"><div class="fw-bold">' +
									item.content +
									'</div>보장금액 : ' +
									item.compensation +'원\n' + 
									'자기부담률 : ' +
									item.rate +
								'</li>'
						);
					}
				});
				$('#guaranteePlanSpecial').html('<ol class="list-group list-group-numbered" id="guaranteePlanSpecial"></ol>');
				$.each(data, function(index, item){
					if(item.special){
						$('#guaranteePlanSpecial').append(
							'<li class="list-group-item d-flex justify-content-between align-items-start">' +
								'<div class="ms-2 me-auto"><div class="fw-bold">' +
									item.content +
									'</div>보장금액 : ' +
									item.compensation +'원]' + 
									'자기부담률 : ' +
									item.rate +
								'</li>'
						);
					}
				});
			},
			error :function(){
				alert("request error in guaranteePlan!");
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
