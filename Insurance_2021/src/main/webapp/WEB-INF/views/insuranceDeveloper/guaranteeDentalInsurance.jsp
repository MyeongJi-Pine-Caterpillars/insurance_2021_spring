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
                       <li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
								<button type="button"
									onclick="location.href='login.do'"
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
						<h1 class="h3 mb-0 text-gray-800">치아 보험 보장 내역 설정하기</h1>
					</div>
					<!-- /.row -->
					<!-- Content Row -->
					<form id="form-guaranteeDentalInsurance" action="checkDentalInsurance" method="get">
					<div class="row">
				
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 1</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("dentalGuarantee1") %></div>
										</div>
										<div class="col mr-2">
										<button id="special1btn" type="button" class="btn btn-primary" onclick="specialBtn('special1')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="레진">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special1" value="레진">
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 2</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("dentalGuarantee2") %></div>
										</div>
										<div class="col mr-2">
										<button id="special2btn" type="button" class="btn btn-primary" onclick="specialBtn('special2')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="크라운">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special2" value="크라운">
										</div>
									</div>
								</div>
							</div>
						</div>
						</div>
						<div class="row">
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 3</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("dentalGuarantee3") %></div>
										</div>
										<div class="col mr-2">
										<button id="special3btn" type="button" class="btn btn-primary" onclick="specialBtn('special3')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="틀니">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special3" value="틀니">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Pending Requests Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 4</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=request.getAttribute("dentalGuarantee4")%></div>
										</div>
										<div class="col mr-2">
										<button id="special4btn" type="button" class="btn btn-primary" onclick="specialBtn('special4')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="임플란트">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special4" value="임플란트">
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="row">
						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 5</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("dentalGuarantee5") %></div>
										</div>
										<div class="col mr-2">
										<button id="special5btn" type="button" class="btn btn-primary" onclick="specialBtn('special5')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="스케일링">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special5" value="스케일링">
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Pending Requests Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												보장 내역 6</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%= request.getAttribute("dentalGuarantee6") %></div>
										</div>
										<div class="col mr-2">
										<button id="special6btn" type="button" class="btn btn-primary" onclick="specialBtn('special6')">일반</button>
										</div>
										<div class="col mr-2 align-items-center">
										<input style="width:100px;"class="form-check-input" name="compensation" type="number">
										</div>
										<div class="row no-gutters align-items-center">
										
											<input style="zoom:1.5" class="form-check-input" type="checkbox"
												name="guaranteeCheckbox" value="발치">
										</div>
										<div class="row no-gutters align-items-center">
											<input style="display:none" class="form-check-input" type="checkbox"
												name="specialCheckbox" id="special6" value="발치">
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
					</form>
						<div class="col">
							<button type="button" class="btn btn-primary" onclick="nextBtn()">설계 완료하기</button>
						</div>
						<script>
							function nextBtn(){
								$("#form-guaranteeDentalInsurance").submit();
								alert("보험 설계가 완료되었습니다.");
							}
							function specialBtn(id){
								var isChecked = $('input[id='+id+']').attr('checked');
								if(isChecked){
									$('#'+id+'btn').css({ background:"#4e73df"});
									$('#'+id+'btn').html('일반')
									$('input[id='+id+']').attr('checked', false)
								} else {
									$('#'+id+'btn').css({ background:"#36b9cc"});
									$('#'+id+'btn').html('특약')
									$('input[id='+id+']').attr('checked', true)
								}
							}
							</script>

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