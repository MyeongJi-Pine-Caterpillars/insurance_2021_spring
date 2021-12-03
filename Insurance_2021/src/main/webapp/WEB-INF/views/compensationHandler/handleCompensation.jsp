<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ page import="java.util.List"%>
<%@ page import="com.insurance.sce.model.contract.Accident"%>
<%@ page import="com.insurance.sce.model.contract.Contract"%>
<%
	List<Accident> accidentList = (List<Accident>)request.getAttribute("accidentList");
	List<Contract> contractList = (List<Contract>)request.getAttribute("contractList");
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
               	 <a class="nav-link" href="handleCompensation.do">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>보상 처리하기</span></a>
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
				<form id="form-handleCompensation" action="handleCompensation/compensate" method="get">
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">보상처리할 사고 리스트</h1>
					</div>

					<!-- Content Row -->
					<div class="row">

						<%for(Accident accident : accidentList){ 
						if(!accident.isHandlingStatus()) {%>
						<div class="col-xl-3 col-md-6 mb-4" id=<%=accident.getAccidentId() %>>
							<div class="cardInsurance border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="h7 mb-0 font-weight-bold text-primary text-uppercase mb-0">
												ID.
												<%=accident.getAccidentId() %></div>
											<div
												class="h5 mb-0 font-weight-bold text-primary text-uppercase mb-3">
												<%=accident.getContent() %></div>
											<div class="h6 mb-0 font-weight-bold text-gray-800">손해액</div>
											<div class="h6 mb-0 font-weight-bold text-gray-800" id=><%=accident.getDamageCost() %>원
											</div>
											<input name="contractId" id="contractId" type="text" style="display: none" value=<%=accident.getContractId() %>>
											<input name="accidentId" id="accidentId" type="text" style="display: none" value=<%=accident.getAccidentId() %>>
											<input id="damageCost" type="text" style="display: none" name=<%=accident.getDamageCost() %>>
											</div>
										</div>
										<div class="col-auto"></div>
									</div>
								</div>
							</div>
						<%}
					}; %>
					
					</div>

					<br>
					<!-- Content Row -->
					<div class="row">

						<!-- Content Column -->
						<div class="col-lg-6 mb-4">

							<!-- Project Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">가입자 정보</h6>
								</div>
								 <div class="card-body">
									<div class="row">
										<div class="col mb-3" id="contractIdBox"></div>
									</div>
									<div class="row">
										<div class="col mb-3" id="insurantName"></div>
										<div class="col" id="insurantAge"></div>
									</div>
									<div class="row">
										<div class="col" id="compensation"></div>
										<div class="col" id="fee"></div>
									</div>
									<div class="row">
										<div class="col" id="compensationCause"></div>
									</div>
									</div>
							</div>
						</div>


						<div class="col-lg-6 mb-4">

							<!-- Illustrations -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">과거 보상 이력</h6>
								</div>
								<div class="card-body">
									<ol class="list-group list-group-numbered" id=past></ol>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="col-lg-6 mb-4">
							<button type="button" class="btn btn-primary btn-lg" onclick="compensate()">보상 처리하기</button>
						</div>
					</div>

				</div>
				</form>
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
		var accidentId = "";
		var contractId = "";
		var insuranceId = "";
		var fee = null;
		var tmpCompensation = null;
		function compensate(){
			if(fee == null) alert("처리할 사고를 선택해주세요.");
			else {
				alert("입력하신 내용으로 보상 처리되었습니다.")
				$("#form-handleCompensation").submit();
			}
		}
		$('.col-xl-3').click(function(){
			accidentId = $('#accidentId').attr('value');
			contractId = $('#contractId').attr('value');
			tmpCompensation = $('#damageCost').attr('name');
			<%for(Contract contract: contractList){%>
				if(contractId == <%=contract.getContractId() %>) {
					fee = <%=contract.getFee() %>;
					insuranceId = <%=contract.getInsuranceId() %>
				}
			<%} %>
			$.ajax({
			url: "handleCompensation/doSelect",
			type: "GET",
			data: {contractId : contractId},
			success : function(data){
					$('#contractIdBox').html('<div class="col mb-3" id="contractIdBox"><h4 class="small font-weight-bold">--계약 정보--</h4></div>');
					$('#contractIdBox').append(
							'<h4 class="small font-weight-bold">계약 ID : <span class="float-center">' +
								contractId +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
					$('#insurantName').html('<div class="col mb-3" id="insurantName"></div>');
					$('#insurantName').append(
							'<h4 class="small font-weight-bold">가입자 이름 : <span class="float-center">' +
								data.name +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
					$('#insurantAge').html('<div class="col mb-3" id="insurantAge"></div>');
					$('#insurantAge').append(
							'<h4 class="small font-weight-bold">가입자 나이 : <span class="float-center">' +
								data.age +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span></h4>'
					);
					$('#compensation').html('<div class="col mb-3" id="compensation"></div>');
					$('#compensation').append(
							'<h4 class="small font-weight-bold">배상금 <div class="float-center"><input step="1000" name="compensation" type="number" value=' +
								tmpCompensation + '>' +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div></h4>'
					);
					$('#fee').html('<div class="col mb-3" id="fee"></div>');
					$('#fee').append(
							'<h4 class="small font-weight-bold">보험료 갱신<div class="float-center"><input step="1000" name="fee" type="number" value=' +
								fee + '>' +
								'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div></h4>'
					);
					$('#compensationCause').html('<div class="col mb-3" id="compensationCause"></div>');
					$('#compensationCause').append(
							'<textarea id="compensationCause" name="compensationCause" rows="7" cols="40" wrap="virtual" placeholder="배상금 책정 이유를 입력해주세요."></textarea>' +
							'&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div></h4>'
					);
			},
			error :function(){
				alert("request error!");
			}
			});
			$.ajax({
			url: "handleCompensation/doSelectCompensationCause",
			type: "GET",
			data: {contractId : contractId},
			success : function(data){
				$('#past').empty();
				$.each(data, function(index, item){
					$('#past').append(
							'<li class="list-group-item d-flex justify-content-between align-items-start">' +
								'<div class="ms-2 me-auto"><div class="fw-bold">' +
									item.content +
									'</div>손해액 : ' +
									item.damageCost +'원\n' + 
									'보상액 : ' +
									item.compensation +
								'</li>'
						);
				});
			},
			error :function(){
				alert("request error!");
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
