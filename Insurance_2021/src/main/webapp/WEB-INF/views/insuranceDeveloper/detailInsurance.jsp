<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${employeeName} 님!</span>
                                <img class="img-profile rounded-circle"
								src="${pageContext.request.contextPath}/resources/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>
                       <li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button"
									onclick="location.href='detailInsurance/doLogout'"
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
						<form id="formdetailInsurance" name="formdetailInsurance" action="goToSpecializeRate" method="get">
							<!-- Illustrations -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="nameBox">보험 이름</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label>보험의 이름을 입력하세요 : </label>
											<div class=form-check>
												<input type="text" name="insuranceName" onChange="nameChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="nameAlarm" style="display: none;">
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

							<!-- Approach -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="feeBox">보험 기본료</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label>기본 보험료를 입력하세요 : </label>
											<div class=form-check>
												<input type="number" name="insuranceFee" value="0"  onChange="feeChange()"> 
											</div>
										</div>
									</div>
									</div>
										<div id="feeAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 1 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
									</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="specialFeeBox">특약 보험료</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label>특약 보험료를 입력하세요 : </label>
											<div class=form-check>
												<input type="number" name="insuranceSpecialFee" value="0" onChange="specialFeeChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="specialFeeAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 0 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
									</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="warrantyPeriodBox">보장 기간</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label>보장기간을 입력하세요(연단위) : </label>
											<div class=form-check>
												<input type="number" name="insuranceWarrantyPeriod" value="0" onChange="warrantyPeriodChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="warrantyPeriodAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 0 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="ageBox">나이별 요율</h6>
								</div>
								<div class="card-body" id="ageList">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName1") %> : </label>
											<div class=form-check>
												<input type="number" name="kidsRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName2") %> : </label>
											<div class=form-check>
												<input type="number" name="teensRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName3") %> : </label>
											<div class=form-check>
												<input type="number" name="twentiesRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName4") %> : </label>
											<div class=form-check>
												<input type="number" name="thirtiesRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName5") %> : </label>
											<div class=form-check>
												<input type="number" name="fourtiesRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName6") %> : </label>
											<div class=form-check>
												<input type="number" name="fiftiesRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("ageRateName7") %> : </label>
											<div class=form-check>
												<input type="number" name="oldersRate" min="0.1" value="1.0" step="0.1" onChange="ageChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="ageAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 0.1 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="genderBox">성별별 요율</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("genderRateName1") %> : </label>
											<div class=form-check>
												<input type="number" name="maleRate" min="0.1" value="1.0" step="0.1" onChange="genderChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("genderRateName2") %> : </label>
											<div class=form-check>
												<input type="number" name="femaleRate" min="0.1" value="1.0" step="0.1" onChange="genderChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="genderAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 0.1 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
								</div>
							</div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary" id="jobBox">직업별 요율</h6>
								</div>
								<div class="card-body">
									<div class="column">
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName1") %> </label>
											<div class=form-check>
												<input type="number" name="officeRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName2") %> : </label>
											<div class=form-check>
												<input type="number" name="driverRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName3") %> : </label>
											<div class=form-check>
												<input type="number" name="factoryRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()">
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName4") %> : </label>
											<div class=form-check>
												<input type="number" name="studentRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName5") %> : </label>
											<div class=form-check>
												<input type="number" name="teacherRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName6") %> : </label>
											<div class=form-check>
												<input type="number" name="soldierRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									<div class = "form-check">
										<div class="row">
											<label><%= request.getAttribute("jobRateName7") %> : </label>
											<div class=form-check>
												<input type="number" name="etcRate" min="0.1" value="1.0" step="0.1" onChange="jobChange()"> 
											</div>
										</div>
									</div>
									</div>
									<div id="jobAlarm" style="display: none;">
											<div
												class="alert alert-danger d-flex align-items-center mt-3">
												<svg class="bi flex-shrink-0 me-2" width="24" height="24"
													role="img" aria-label="Danger:">
													<use xlink:href="#exclamation-triangle-fill" /></svg>
												<div>&nbsp 0.1 이상의 숫자를 입력해주세요!!</div>
											</div>
										</div>
								</div>
							</div>
							</form>
							<div class="col">
								<button type="button" class="btn btn-primary" onclick="nextBtn()">다음 단계로</button>
							</div>
							<script>
							function nextBtn(){
								form = document.formdetailInsurance;
								if(form.insuranceName.value == "") {
									form.insuranceName.style.borderColor = "red";
									document.getElementById("nameBox").scrollIntoView();
									$('#nameAlarm').show();
								} else if(form.insuranceFee.value == null || form.insuranceFee.value <= 0) {
									form.insuranceFee.style.borderColor = "red";
									document.getElementById("feeBox").scrollIntoView();
									$('#feeAlarm').show();
								} else if(form.insuranceSpecialFee.value == null || form.insuranceSpecialFee.value < 0) {
									form.insuranceSpecialFee.style.borderColor = "red";
									document.getElementById("specialFeeBox").scrollIntoView();
									$('#specialFeeAlarm').show();
								} else if(form.insuranceWarrantyPeriod.value == null || form.insuranceWarrantyPeriod.value <= 0) {
									form.insuranceWarrantyPeriod.style.borderColor = "red";
									document.getElementById("warrantyPeriodBox").scrollIntoView();
									$('#warrantyPeriodAlarm').show();
								} else if(form.kidsRate.value == null || form.kidsRate.value <= 0 || form.teensRate.value == null || form.teensRate.value <= 0
										|| form.twentiesRate.value == null || form.twentiesRate.value <= 0 || form.thirtiesRate.value == null || form.thirtiesRate.value <= 0
										|| form.fourtiesRate.value == null || form.fourtiesRate.value <= 0 || form.fiftiesRate.value == null || form.fiftiesRate.value <= 0
										|| form.oldersRate.value == null || form.oldersRate.value <= 0) {
									document.getElementById("ageBox").style.borderColor = "red";
									document.getElementById("ageBox").scrollIntoView();
									$('#ageAlarm').show();
								} else if(form.maleRate.value == null || form.maleRate.value <= 0 || form.femaleRate.value == null || form.femaleRate.value <= 0) {
									document.getElementById("genderBox").style.borderColor = "red";
									document.getElementById("genderBox").scrollIntoView();
									$('#genderAlarm').show();
								} else if(form.officeRate.value == null || form.officeRate.value <= 0 || form.driverRate.value == null || form.driverRate.value <= 0
										 || form.factoryRate.value == null || form.factoryRate.value <= 0 || form.studentRate.value == null || form.studentRate.value <= 0
										 || form.teacherRate.value == null || form.teacherRate.value <= 0 || form.soldierRate.value == null || form.soldierRate.value <= 0
										 || form.etcRate.value == null || form.etcRate.value <= 0) {
									document.getElementById("jobBox").style.borderColor = "red";
									document.getElementById("jobBox").scrollIntoView();
									$('#jobAlarm').show();
								} else {
									form.submit();
								}
								
							}
							function nameChange() {
								form.insuranceName.style.borderColor = "#D1D3E2";
								$('#nameAlarm').hide();
							}
							function feeChange() {
								form.insuranceFee.style.borderColor = "#D1D3E2";
								$('#feeAlarm').hide();
							}

							function specialFeeChange() {
								form.insuranceSpecialFee.style.borderColor = "#D1D3E2";
								$('#specialFeeAlarm').hide();
							}
							function warrantyPeriodChange() {
								form.insuranceWarrantyPeriod.style.borderColor = "#D1D3E2";
								$('#warrantyPeriodAlarm').hide();
							}
							function ageChange() {
								document.getElementById("ageBox").style.borderColor = "#D1D3E2";
								$('#ageAlarm').hide();
							}
							function genderChange() {
								document.getElementById("genderBox").style.borderColor = "#D1D3E2";
								$('#genderAlarm').hide();
							}
							function jobChange() {
								document.getElementById("jobBox").style.borderColor = "#D1D3E2";
								$('#jobAlarm').hide();
							}
							</script>
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
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="resources/vendor/jquery/jquery.min.js" />"></script>
    <script src="<c:url value="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value="resources/vendor/jquery-easing/jquery.easing.min.js" />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value="resources/js/sb-admin-2.min.js" />"></script>

    <!-- Page level plugins -->
    <script src="<c:url value="resources/vendor/chart.js/Chart.min.js" />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value="resources/js/demo/chart-area-demo.js" />"></script>
    <script src="<c:url value="resources/js/demo/chart-pie-demo.js" />"></script>

</body>

</html>