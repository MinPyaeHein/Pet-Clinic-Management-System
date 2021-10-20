
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
        <div class="row mb-2">
          <div class="col">
            <h1>All Show Appointment</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="#"><c:choose>
                                       <c:when test="${idType=='id'}"> Admin</c:when>
                                       <c:when test="${idType=='doctor'}">Doctor</c:when>
                                       <c:when test="${idType=='oid'}">Owner</c:when>
                                      </c:choose> Home</a></li>
              <li class="breadcrumb-item active">Show Appointment</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

 <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Show All Appointment</h3>
              </div>
        <div class="card-body">
          
                <!-- /.form-group -->
              
              <!-- /.col -->
              </div>
            </div>
       <section class="content">
        <h3>Show All appointment</h3>
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
             
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
              <thead>
         	<tr>
			<th> No</th>
			<th>Appointment Id</th>
			<th>Owner Name</th>
			<th>Pet Name</th>
			<th>Appointment Date</th>
			<th>Appointment Time</th>
			<th>Servic Name</th>
			<th>Appointment Info</th>
				</tr>
                </thead>
                <tbody>
          <c:forEach var="at" items="${appointmentRegisterForm.appointments}" varStatus="s">
         
		    	<tr>
				<td>${s.index+1}</td>
				<td>${at.appointmentId}</td>
				<td>${at.owner.ownerName}</td>
				<td>${at.pet.petName}</td>
				<td>${at.appointmentDate}</td>
				<td>${at.appointmentTime}</td>
				 <c:forEach var="as" items="${at.appointmentServics}" varStatus="s">
				 <td>${as.servic.servicName},</td>
				 </c:forEach>
				<td>${at.appointmentInfo }</td>
				</tr>		
		   </c:forEach>
                </tbody>
                <tfoot>
             
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
  <%@ include file="/resources/admin/footer/footer.jsp" %>

<!-- jQuery -->
<script src="<c:url value="resources/admin/plugins/jquery/jquery.min.js"/>"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- DataTables -->
<script src="<c:url value="resources/admin/plugins/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="resources/admin/dist/js/adminlte.min.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="resources/admin/dist/js/demo.js"/>"></script>
<!-- page script -->
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
