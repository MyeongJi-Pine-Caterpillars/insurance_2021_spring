<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ page import="java.util.List"%>
<%@ page import="com.insurance.sce.model.insurance.FireInsurance"%>
<%
	List<FireInsurance> insuranceList = (List<FireInsurance>)request.getAttribute("insuranceList");
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


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
				<div class="sidebar-brand-text mx-3" id="test" onclick="selectInsurance();">
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
				href="actualCostInsurance"> <i class="fas fa-fw fa-hospital"></i> <span>실비보험</span></a>
			</li>

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
									onclick="location.href='selectFireInsurance/doLogout'"
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
						<h1 class="h3 mb-0 text-gray-800">화재보험</h1>
					</div>
					
					<!-- Content Row -->
					<div class="row">
					
					<%for(FireInsurance insurance : insuranceList){ %>					
						<div class="col-xl-3 col-md-6 mb-4" id=<%=insurance.getInsuranceId() %>>
							<div class="cardInsurance border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="h7 mb-0 font-weight-bold text-primary text-uppercase mb-0">
												ID. <%=insurance.getInsuranceId() %></div>
											<div class="h5 mb-0 font-weight-bold text-primary text-uppercase mb-3">
												<%=insurance.getName() %></div>
											<div class="h6 mb-0 font-weight-bold text-gray-800">
												기본 보험료</div>
											<div class="h6 mb-0 font-weight-bold text-gray-800"><%=insurance.getBasicFee() %>원</div>
										</div>
										<div class="col-auto"></div>
									</div>
								</div>
							</div>
						</div>
					<%}; %>

					</div>

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
										<div class="col" id="rateOfStructureUsage"></div>
										<div class="col" id="rateOfPostedPrice"></div>
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
										<ol class="list-group list-group-numbered" id="guaranteePlanSpecial"></ol>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-lg-6 mb-4">
								<button type="button" class="btn btn-primary btn-lg" onClick="signUpInsurant();">가입 신청하기</button>
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
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a classl="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="ajax_indicator" style="display:none;">
			<p style="text-align: center; padding: 16px 0 0 0; left: 50%; top: 50%; position: absolute;">
				<img src="${pageContext.request.contextPath}/resources/img/loading.gif" />
			</p>
		</div>
		
		<script>
			var ages = ["영유아", "10대", "20대", "30대", "40대", "50대", "노년층"];
			var jobs = ["사무직", "운송업", "현장직", "학생", "교육직", "군인", "기타"];
			var gender = ["남성", "여성"];
			var postedPrice = ["주택", "교육", "공장", "창고", "사무", "공공시설"];
			var structureUsage = ["~5천만원", "5천만원~5억", "5억~10억", "10억~20억", "20억~"];
			var insuranceId = "";
			
			$('.col-xl-3').click(function(){
				insuranceId = {"insuranceId" : $(this).attr('id')};
				$.ajax({
					url: "selectFireInsurance/doSelect",
					type: "GET",
					data: insuranceId,
							
					success : function(data){
						$('#rateOfStructureUsage').html('<div class="col mb-3" id="rateOfGender"><h4 class="small font-weight-bold">--건축물 용도 요율표--</h4></div>');
						$.each(data.rateOfStructureUsage, function(index, item){
							$('#rateOfStructureUsage').append(
									'<h4 class="small font-weight-bold">'+ structureUsage[index] +'<span class="float-right">' +
										item +
										'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
							);
						});
						$('#rateOfPostedPrice').html('<div class="col mb-3" id="rateOfGender"><h4 class="small font-weight-bold">--공시가격 요율표--</h4></div>');
						$.each(data.rateOfPostedPrice, function(index, item){
							$('#rateOfPostedPrice').append(
									'<h4 class="small font-weight-bold">'+ postedPrice[index] +'<span class="float-right">' +
										item +
										'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
							);
						});
					},
					error :function(){
						alert("request error!");
					}
				});
				
				$.ajax({
					url: "selectFireInsurance/doSelectGuaranteePlan",
					type: "GET",
					data: insuranceId,
					
					beforeSend: function() {
						$('#ajax_indicator').show().fadeIn('fast');
					},
					complete: function() {
						$('#ajax_indicator').fadeOut();
					},
							
					success : function(data){
						$('#guaranteePlan').html('<ol class="list-group list-group-numbered" id="guaranteePlan"></ol>');
						$.each(data, function(index, item){
							if(!item.special){
								$('#guaranteePlan').append(
									'<li class="list-group-item d-flex justify-content-between align-items-start">' +
										'<div class="ms-2 me-auto"><div class="fw-bold">' +
											item.content +
										'</div>최대 보장금액 : ' +
											item.compensation +
										'원<br>보장비율 : '+
											item.rate*100 +
										'%</li>'
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
											item.compensation +
										'원<br>보장비율 : '+
											item.rate*100 +
										'%</li>'
								);
							}
						});
					},
					error :function(){
						alert("request error in guaranteePlan!");
					}
				});
			});

			function signUpInsurant(){
				if(insuranceId == ""){
					alert("보험을 선택해주세요")
				}else{
					location.href="signUpInsurant?insuranceId="+insuranceId["insuranceId"]+"&insuranceType=Fire";
				}
			}
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