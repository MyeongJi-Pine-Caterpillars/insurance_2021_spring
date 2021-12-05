<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.insurance.sce.model.insurance.GuaranteePlan"%>

<%
List<GuaranteePlan> guaranteePlanList = (List<GuaranteePlan>) request.getAttribute("guaranteePlanList");
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
						<h1 class="h3 mb-0 text-gray-800">사고접수하기</h1>
					</div>


					<br>
					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4">

							<!-- Project Card Example -->
						
					<div class="row">
					<%for(GuaranteePlan guaranteePlan : guaranteePlanList){ %>					
						<div class="col-xl-3 col-md-6 mb-4" onclick="selectInsurance();" id=<%=guaranteePlan.getContent() %> 
						compensation=<%=guaranteePlan.getCompensation() %> rate=<%=guaranteePlan.getRate()%>>
							<div class="cardInsurance border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="h5 mb-0 font-weight-bold text-primary text-uppercase mb-3">
												<%=guaranteePlan.getContent() %></div>
											<div class="h6 mb-0 font-weight-bold text-gray-800">
												<span class="guaranteeRate" style="display:none">최대 </span>보장금액 : <%=guaranteePlan.getCompensation() %></div>
											<div class="h6 mb-0 font-weight-bold text-gray-800 guaranteeRate" style="display:none">보장비율 : <%=guaranteePlan.getRate()*100%>%</div>
										</div>
										<div class="col-auto"></div>
									</div>
								</div>
							</div>
						</div>
					<%}; %>	
					</div>
					<form name="formDamageCost" action="doRegisterAccident"
								method="get">
								<div class="card shadow mb-4 guaranteeRate" style="display:none">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary" id="age">피해액</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<label>피해액을 입력해주세요 : </label>
													<div class="col-2">
														<input type="number" class="form-control"
															name="damageCost" min='0'
															onChange="change();" id="damage">
													</div>
												</div>
											</div>
											<div id="damageCostAlarm" style="display: none;">
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
								
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary" id="age">보장금액</h6>
									</div>
									<div class="card-body">
										<div class="column">
											<div class="form-check">
												<div class="row">
													<p id="compensation"></p>
												</div>
											</div>
											
										</div>
									</div>
								</div>
							
							
							
						<div class="row">
							<div class="col-lg-6 mb-4">
								<button type="button" class="btn btn-primary btn-lg" 
								onClick="registerAccident();"
								id="registerBtn">확인</button>
							</div>
						</div>
							</form>
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

	<div id="ajax_indicator" style="display: none;">
		<p
			style="text-align: center; padding: 16px 0 0 0; left: 50%; top: 50%; position: absolute;">
			<img
				src="${pageContext.request.contextPath}/resources/img/loading.gif" />
		</p>
	</div>

	<script>
	var content = "";
	var compensation;
	var rate;
	
	$(document).ready(function(){
		if("${type}" == "화재보험" || "${type}" == "운전자보험"){
			$('.guaranteeRate').show();
		}
	});
	
	$('.col-xl-3').click(function(){
		content = {"content" : $(this).attr('id')};
		compensation = $(this).attr('compensation');
		rate = $(this).attr('rate');
		if("${type}" == "암보험" || "${type}" == "치과보험"){
			$('#compensation').text(content.content + "의 보장금액은 " + compensation + "원입니다.");
		}
	});
	
	
	$("#damage").bind("propertychange change keyup paste input", function() {
	    var currentVal = $(this).val();
		form = document.formDamageCost;
		if(content == ""){
			alert("보장내역을 선택해주세요")
		}
		
		if("${type}" == "화재보험" || "${type}" == "운전자보험"){
			if(form.damageCost.value > compensation){
				$('#compensation').text(content.content + "의 보장금액은 " + compensation + "원입니다.");
			}else{
				$('#compensation').text(content.content + "의 보장금액은 " + form.damageCost.value*rate + "원입니다.");
			}
			
		}
	 
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