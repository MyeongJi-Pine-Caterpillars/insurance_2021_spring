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

<title>송충이들</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">송충이들</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
           <li class="nav-item active">
               	 <a class="nav-link" href="confirmInsurance.do">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>보험 확정하기</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Insurance
            </div>
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                   

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">


                        <div class="topbar-divider d-none d-sm-block"></div>
                       <li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button"
									onclick="location.href='loginEmployee.do'"
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
						<h1 class="h3 mb-0 text-gray-800">확정할 보험 리스트</h1>
					</div>

					<!-- Content Row -->
					<div class="row">
						<%int confirming = 0;%>
						<%for(Insurance insurance : insuranceList){ 
						if(!insurance.isConfirmedStatus() && !insurance.isDel()) {%>
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
						<%confirming = 1;
						}
					}; %>
					<%if(confirming == 0) { %>
						<h1 class="h2 mb-0 text-gray-800">확정할 보험이 존재하지 않습니다.</h1>
					<%} %>
					</div>
					<form id="form-confirmerView" action="confirmerView/confirmInsurance" method="get">
						<input style="display:none" class="form-check-input" type="text"
												name="confirmInsuranceId" id="confirmInsuranceId">
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
										<div class="col mb-3" id="rateOfAgeBox"></div>
										<div class="col" id="rateOfJobBox"></div>
									</div>
									<div class="row">
										<div class="col mb-3" id="rateOfGenderBox"></div>
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
							<button type="button" class="btn btn-primary btn-lg" onclick="confirm()">보험 확정하기</button>
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
<div id="ajax_indicator" style="display:none;">
			 							<p style="text-align: center; padding: 16px 0 0 0; left: 50%; top: 50%; position: absolute;">
			 								<img src="${pageContext.request.contextPath}/resources/img/loading.gif" />
			 							</p>
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
		function confirm(){
			$('#confirmInsuranceId').val(insuranceId);
			if(insuranceId == 0) alert("확정할 보험을 선택해주세요.");
			else {
				alert("보험이 확정되었습니다.")
				$("#form-confirmerView").submit();
			}
		}
		$('.col-xl-3').click(function(){
			$('#rateOfAgeBox').empty();
			$('#rateOfJobBox').empty();
			$('#rateOfGenderBox').empty();
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
			url: "confirmInsurance/doSelect",
			type: "GET",
			data: insuranceId,
			
			beforeSend: function() {
				$('#ajax_indicator').show().fadeIn('fast');
			},
			complete: function() {
				$('#ajax_indicator').fadeOut();
			}, 
			
			success : function(data){
				insuranceId = data.insuranceId;
				
				$('#rateOfAgeBox').html('<div class="col mb-3" id="rateOfAge"><h4 class="small font-weight-bold">--나이 요율표--</h4></div>');
				$.each(data.rateOfAge, function(index, item){
					$('#rateOfAge').append(
							'<h4 class="small font-weight-bold">'+ ages[index] +'<span class="float-right">' +
								item +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				});
				$('#rateOfJobBox').html('<div class="col mb-3" id="rateOfJob"><h4 class="small font-weight-bold">--직업 요율표--</h4></div>');
				$.each(data.rateOfJob, function(index, item){
					$('#rateOfJob').append(
							'<h4 class="small font-weight-bold">'+ jobs[index] +'<span class="float-right">' +
								item +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
				});
				$('#rateOfGenderBox').html('<div class="col mb-3" id="rateOfGender"><h4 class="small font-weight-bold">--성별 요율표--</h4></div>');
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
							'<h4 class="small font-weight-bold">&nbsp&nbsp&nbsp'+ annualLimitCount +'<span class="float-right">' +
								data.annualLimitCount +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
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
			url: "confirmInsurance/doSelectGuaranteePlan",
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
									item.compensation +'원&nbsp&nbsp&nbsp' + 
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
									item.compensation +'원&nbsp&nbsp&nbsp' + 
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
