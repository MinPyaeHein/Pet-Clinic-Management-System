
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/resources/admin/header/header.jsp" %>
<%@ include file="/resources/admin/header/HeaderAndMainSlider.jsp" %>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
   <div class="content-wrapper">
  <section class="content">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-25">
          <div class="col">
           
          </div>
          <div class="col-sm-25">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Doctor Home</a></li>
              <li class="breadcrumb-item active">Doctor Schedules</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
      
         <section class="content">
      <div class="row">
        <div class="col-15">
        
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Doctor Schedules</h3>
              </div>
        <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
               <tr>
 			<th>No</th>
			<th>Schedule Id</th>
			<th>Day Name</th>
			<th>Start Time</th>
			<th>End Time</th>
            <th>Appointments</th>
		       </tr>
                </thead>
                <tbody>
            <c:forEach var="at" items="${doctorRegisterForm.doctorSchedules}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.scheduleId}</td>
				<td>${at.dayName}</td>
				<td>${at.startTime}</td>
				<td>${at.endTime}</td>
				<td><a href="showAppointmentBySchedulePath?frmScheduleId=${at.scheduleId}"class="btn btn-block btn-outline-primary btn-sm">Appointments</a></td>
			</tr>		
		</c:forEach>
                </tbody>
                <tfoot>
                 <tr>
			<th>No</th>
			<th>Schedule Id</th>
			<th>Day Name</th>
			<th>Start Time</th>
			<th>End Time</th>
            <th>Show Appointments</th>
		       </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    </section>
  </div>
  <!-- /.content-wrapper -->
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
<script src="<c:url value="resources/admin/plugins/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.js"/>"></script>
<script src="<c:url value="resources/admin/dist/js/demo.js"/>"></script>
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
