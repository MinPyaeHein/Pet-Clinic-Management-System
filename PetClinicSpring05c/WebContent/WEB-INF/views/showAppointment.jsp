
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
            <h1>Show Appointment>>Step(2)</h1>
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
                <h3 class="card-title">Get Appointment By Date</h3>
              </div>
        <div class="card-body">
          <form:form action="showAppointmentPath3" modelAttribute="showAppointmentForm" method="POST" enctype="multipart/form-data" >
      
	       
              <div class="card-body">
             <div class="row">
        	<div class="col-md-6">
        	    
         		<div class="form-group">
				  Appointment Date :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="date" path="date" name="date"  class="form-control"  data-mask="data-mask"  placeholder="dd/MM/yyyy"/>
                  </div>
         		 </div>
         	     
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit"  name="refresh" 
             class="btn btn-block bg-gradient-primary btn-m" value="Refresh"/>
             </div>
            </div>
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit"  name="exit" 
             class="btn btn-block bg-gradient-primary btn-m" value="Exit"/>
             </div>
            </div>
          </div>
			 </div>
			
         	
		</div>
            
              </form:form>
             
                <!-- /.form-group -->
              
              <!-- /.col -->
              </div>
            </div>
       <section class="content">
        <h3>Apply Algorithms</h3>
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
			<th>Process No</th>
			<th>Owner Id</th>
			<th>Owner Name</th>
			<th>App Id</th>
			<th>Completion Time</th>
			<th>Wating Time</th>
			<th>Servic Time</th>
			<th>Turnaround Time</th>
				</tr>
                </thead>
                <tbody>
          <c:forEach var="at" items="${showAppointmentForm.shortestJobFirstForms}" varStatus="s">
		    	<tr>
				<td>${s.index+1}</td>
				<td>${at.ownerId}</td>
				<td>${at.ownerName}</td>
				<td>${at.appId}</td>
				<td>${at.completionTime}</td>
				<td>${at.waitingTime}</td>
				<td>${at.servicTime}</td>
				<td>${at.turnaroundTime}</td>
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
      Wating Time Average:${showAppointmentForm.watingAvg }<br>
     Turnaround Time Average:${showAppointmentForm.turnAvg }
    </section>
     
       <section class="content">
       <h3>Don't Use Algorithms</h3>
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
			<th>Process No</th>
			<th>Owner Id</th>
			<th>Owner Name</th>
			<th>App Id</th>
			<th>Completion Time</th>
			<th>Wating Time</th>
			<th>Servic Time</th>
			<th>Turnaround Time</th>
				</tr>
                </thead>
                <tbody>
          <c:forEach var="at" items="${showAppointmentForm.noShortestJobFirstForms}" varStatus="s">
		    	<tr>
				<td>${s.index+1}</td>
				<td>${at.ownerId}</td>
				<td>${at.ownerName}</td>
				<td>${at.appId}</td>
				<td>${at.completionTime}</td>
				<td>${at.waitingTime}</td>
				<td>${at.servicTime}</td>
   				<td>${at.turnaroundTime}</td>
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
     Wating Time Average:${showAppointmentForm.noWatingAvg }<br>
     Turnaround Time Average:${showAppointmentForm.noTurnAvg }
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
