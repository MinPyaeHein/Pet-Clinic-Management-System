
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
   <link rel="stylesheetbar" href="<c:url value="resources/admin/plugins/barChart/style.css"/>">
    <link rel="stylesheetbar" href="<c:url value="resources/admin/plugins/barChart/cssgraph_bar.css"/>">
    <link rel="stylesheetbar" href="<c:url value="resources/admin/plugins/barChart/cssgraph_plot.css"/>">
 
      
            
  <div class="content-wrapper">
  <section class="content">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col">
           <h1>Owner Register</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin Home</a></li>
              <li class="breadcrumb-item active">Owner Register</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
        <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Owner Register</h3>
              </div>
        <div class="card-body">
          <form:form action="ownerRegisterSubmitPath" modelAttribute="ownerRegisterForm.ownerForm" method="POST" enctype="multipart/form-data" >
      
	       
                <div class="card-body">
                <div class="row">
        	    <div class="col-md-6">
        	     <div class="form-group">
				Owner Id :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="ownerId" path="ownerId" name="ownerId"  class="form-control"  data-mask="data-mask" readonly="true"/>
                  </div>
         		 </div>
         		 <div class="form-group">
				Owner Name :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="ownerName" path="ownerName" name="ownerName"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
         		  <div class="form-group">
				Password :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="password" id="ownerPassword" path="ownerPassword" name="ownerPassword"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
         		   <div class="form-group">
				Gender :
         		 <div class="input-group">
                       <div class="form-check">
                         <form:radiobutton path="ownerGender" value="M" class="form-check-input" name="ownerGender"/>
                          <label class="form-check-label">Male</label>
                        </div><br>
                        <div class="form-check">
                         <form:radiobutton path="ownerGender" value="F" class="form-check-input" name="ownerGender"/>
                          <label class="form-check-label">Female</label>
                        </div>
                    </div>
                    </div>
                    
         		<div class="form-group">
				Owner Gmail :
                <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="ownerEmail" path="ownerEmail" name="ownerEmail"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
         		 
         		<div class="form-group">
				Owner Address :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="ownerAddress" path="ownerAddress" name="ownerAddress"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
         		 <div class="form-group">
         		 Owner phone :
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
                    </div>
                 <form:input type="text" id="ownerPh" path="ownerPh" name="ownerPh"  class="form-control"  data-mask="data-mask" />
                  </div>
         		 </div>
             <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit" name="save"
             class="btn btn-block bg-gradient-primary btn-m" value="Save"/>
             </div>
            </div>
            
              <div class="form-group">
	             <div class="input-group">
	             <div class="input-group-prepend">
                 <span></span>
                    </div>
              <input type="submit" name="exit"
             class="btn btn-block bg-gradient-primary btn-m" value="Exit"/>
             </div>
            </div>
          </div>
			 </div>
			
         	   </form:form>
		</div> 
            
           
             
                <!-- /.form-group -->
              
              <!-- /.col -->
              </div>
              </section>
           </div>
    
    <!-- /.content -->
   
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
