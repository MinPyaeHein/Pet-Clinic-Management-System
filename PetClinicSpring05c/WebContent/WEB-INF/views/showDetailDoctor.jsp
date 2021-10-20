<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Paint Shop</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/fontawesome-free/css/all.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
  <!-- JQVMap -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/jqvmap/jqvmap.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="resources/admin/dist/css/adminlte.min.css"/>">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.css"/>">
  <!-- summernote -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/summernote/summernote-bs4.css"/>">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

 <%@ include file="/resources/admin/headerAndSlideBar/headerAndSlideBar.jsp" %>

  <div class="content-wrapper">
  <section class="content">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col">
            <h1>Detail Doctor Information</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">
               Doctor Home
              </a></li>
              <li class="breadcrumb-item active">Detail Doctor Information</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->

        	  <div class="col-md-4">
            <!-- Widget: user widget style 2 -->
            <div class="card card-widget widget-user-2">
               
              <!-- Add the bg color to the header using any of the bg-* classes -->
              <div class="widget-user-header bg-warning">
                <div class="widget-user-image">
                <img class="img-circle elevation-2" src="bgimageUploadPath?frmImageId=${teacher.teacherId}&frmType=teacher" alt="User Avatar">
                </div>
                <!-- /.widget-user-image -->
                <h3 class="widget-user-username">Doctor Id::${doctor.teacherId}</h3>
                <h3 class="widget-user-username"> Doctor Name::${teacher.teacherName}</h3>
 
              </div>
              <div class="card-footer p-0">
                <ul class="nav flex-column">
  
                  <li class="nav-item">
                  <a href="#" class="nav-link">
                  Position Name :: ${teacher.position.positionName}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                   Member Name :: ${teacher.member.memberName}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                  Gender :: ${teacher.gender}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                   Phone :: ${teacher.phone}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    Email :: ${teacher.email}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    AcademicYear :: ${teacher.academicYear.startYear}-${teacher.academicYear.endYear}
                     </a>
                  </li>
                    <li class="nav-item">
                    <a href="#" class="nav-link">
                    Address :: ${teacher.address}
                     </a>
                  </li>
                     <li class="nav-item">
                    <a href="#" class="nav-link">
                    Address1 :: ${teacher.address1}
                     </a>
                  </li>
                 <li class="nav-item">
              
           <form:form action="showDetailTeacherPath" >
             
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
              </div>
              <input type="submit" name="exit"
             class="btn btn-block bg-gradient-primary btn-m" value="Exit"/>
             </div>
            </div>
             
 			</form:form> 
                  </li>
                </ul>
              </div>
            </div>
            <!-- /.widget-user -->
           
          </div>

    
   
    </section>
    <!-- /.content -->
   
          </div>
			 
  <!-- /.content-wrapper -->
  <%@ include file="/resources/admin/footer/AdminFooter.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<c:url value="resources/admin/plugins/jquery/jquery.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="resources/admin/plugins/jquery-ui/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- ChartJS -->
<script src="<c:url value="resources/admin/plugins/chart.js/Chart.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value="resources/admin/plugins/sparklines/sparkline.js"/>"></script>
<!-- JQVMap -->
<script src="<c:url value="resources/admin/plugins/jqvmap/jquery.vmap.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value="resources/admin/plugins/jquery-knob/jquery.knob.min.js"/>"></script>
<!-- daterangepicker -->
<script src="<c:url value="resources/admin/plugins/moment/moment.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.js"/>"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"/>"></script>
<!-- Summernote -->
<script src="<c:url value="resources/admin/plugins/summernote/summernote-bs4.min.js"/>"></script>
<!-- overlayScrollbars -->
<script src="<c:url value="resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="resources/admin/dist/js/adminlte.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value="resources/admin/dist/js/pages/dashboard.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="resources/admin/dist/js/demo.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.js"/>"></script>
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
    });
  });
</script>
</body>
</html>
