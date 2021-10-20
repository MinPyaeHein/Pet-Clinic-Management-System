
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
            <h1>Species Register</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Owner Home</a></li>
              <li class="breadcrumb-item active">Species Register</li>
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
                
           
           
                  <img class="img-circle elevation-2" src="<c:url value="resources/admin/dist/img/user7-128x128.jpg"/>" alt="User Avatar">
                </div>
                <!-- /.widget-user-image -->
                 <h3 class="widget-user-username">oid-${owner.ownerId}</h3>
                <h3 class="widget-user-username">${owner.ownerName}</h3>
                <h5 class="widget-user-desc">Pet Owner</h5>
              </div>
              <div class="card-footer p-0">
                <ul class="nav flex-column">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                   Name :: ${owner.ownerName}
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                   Phone :: ${owner.ownerPh}  
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                   Gender :: ${owner.ownerGender}
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                   Email :: ${owner.ownerEmail}<br>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                  Address :: ${owner.ownerAddress}<br>
                    </a>
                  </li>
                   <li class="nav-item">
                  <form:form action="servicRegisterSubmitPath" method="POST" enctype="multipart/form-data" >
           
             
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
       <section class="content">
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
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Gender</th>
			<th>Species</th>
			<th>Birth Date</th>
			<th>Death Date</th>
			<th>Owner</th>
            <th>Delete</th>
			<th>Update</th>
		       </tr>
                </thead>
                <tbody>
             <c:forEach var="at" items="${owner.pets}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${at.petId}</td>
				<td>${at.petName}</td>
				<td>${at.petSex}</td>
				<td>${at.species.speciesName}</td>
				<td>${at.petBirth}</td>
				<td>${at.petDeath}</td>
				<td>${at.owner.ownerName}</td>
				<td><a href="speciesDeletePath?frmSpeciesId=${at.petId}" class="btn btn-block btn-outline-primary btn-sm">Delete</a></td>
				<td><a href="speciesUpdatePath?frmSpeciesId=${at.petId}" class="btn btn-block btn-outline-primary btn-sm">Update</a></td>
			</tr>		
		    </c:forEach>
                </tbody>
                <tfoot>
                
              <tr>
			<th>No</th>
			<th>Pet Id</th>
			<th>Pet Name</th>
			<th>Gender</th>
			<th>Species</th>
			<th>Birth Date</th>
			<th>Death Date</th>
			<th>Owner</th>
            <th>Delete</th>
			<th>Update</th>
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
