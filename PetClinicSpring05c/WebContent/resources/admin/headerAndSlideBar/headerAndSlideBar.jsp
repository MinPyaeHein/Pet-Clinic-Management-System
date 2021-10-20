<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

 
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
      
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  
   

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="homePath" class="brand-link">
     <c:choose>
     <c:when test="${login!=null}">
      <img src="bgimageUploadPath?frmImageId=${login.userId}&frmType=admin" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      </c:when>
       <c:when test="${(loginObj!=null)&&(idType=='sid')}">
      <img src="bgimageUploadPath?frmImageId=${loginObj.userId}&frmType=student" class="brand-image img-circle elevation-3"
        style="opacity: .8">
      </c:when>
      <c:when test="${(loginObj!=null)&&(idType=='tid')}">
      <img src="bgimageUploadPath?frmImageId=${loginObj.userId}&frmType=teacher" class="brand-image img-circle elevation-3"
        style="opacity: .8">
      </c:when>
      </c:choose>
      <span class="brand-text font-weight-light">Library 
                                       <c:choose>
                                       <c:when test="${idType=='id'}"> Admin</c:when>
                                       <c:when test="${idType=='sid'}">Student</c:when>
                                       <c:when test="${idType=='tid'}">teacher</c:when>
                                      </c:choose>
                                       </span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
        <div class="info">
        <c:choose>
        <c:when test="${idType!=null}">
           <c:choose>
           <c:when test="${login!=null}">
          <a href="#" class="d-block">${login.userId}</a>
          <a href="#" class="d-block">${login.userName}</a>
            </c:when>
             <c:when test="${loginObj!=null}">
          <a href="#" class="d-block">${loginObj.userId}</a>
          <a href="#" class="d-block">${loginObj.userName}</a>
            </c:when>
            </c:choose>
          </c:when>
          <c:when test="${idType==null}">  
          <a href="#" class="d-block">Unknow User</a>
          </c:when>
          </c:choose>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
               Dashboard
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="homePath" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                    <c:choose>
              <c:when test="${idType=='id'}"> <p> Admin Home </p></c:when>
             <c:when test="${idType=='sid'}"> <p> Student Home</p></c:when>
              <c:when test="${idType=='tid'}"> <p>Teacher Home</p></c:when>
              
              </c:choose>
                
                </a>
              </li>
             
            </ul>
             <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="logoutPath" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>LogOut</p>
                </a>
              </li>
             
            </ul>
          </li>
         </ul>
      </nav>
      
           <c:choose>
           <c:when test="${idType=='sid'}">
           
           <nav class="mt-2">
           <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
           <li class="nav-item has-treeview" >
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
               Show Data Table
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="showRentStudentPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Show Rent Book        
              </p>
            </a>
          </li>          
           <li class="nav-item">
            <a href="showReturnStudentPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Show Return Book        
              </p>
            </a>
          </li>
           
           <li class="nav-item">
            <a href="showDetailStudentPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Show User Detail       
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="saveBookConfrimSubmitPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Book
              </p>
            </a>
          </li>          
          <li class="nav-item">       
          </ul>
          </li>
           </ul>
           </nav>
          </c:when>
          </c:choose>
       
          <c:choose>
          <c:when test="${idType=='tid'}">
            <nav class="mt-2">
           <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <li class="nav-item has-treeview ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
               Show Data Table
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="showRentTeacherPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Show Rent Book        
              </p>
            </a>
          </li>
             <li class="nav-item">
            <a href="showReturnTeacherPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Show Return Book        
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="saveBookConfrimSubmitPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Book
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="showDetailTeacherPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
            Show User Detail
              </p>
            </a>
          </li>
          </ul>       
          </li>
          </ul>
          </nav>
          </c:when>
          </c:choose>
          
          <c:choose>
          <c:when test="${idType=='id'}">
          
         <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <li class="nav-item has-treeview ">
            <a href="#" class="nav-link ">
               <i class="nav-icon fas fa-edit"></i>
              <p>
               Rent Return Book 
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="rentBookLoginPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Rent Book        
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="returnLoginPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Return Book        
              </p>
            </a>
          </li>
          </ul>
          </li>
       </ul>
       </nav>
       
          <nav class="mt-2">
           <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
           <li class="nav-item has-treeview ">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-edit"></i>
              <p>
               User Register Pages
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
            <li class="nav-item">
            <a href="testMailPath?from=student" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Student Register              
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="testMailPath?from=teacher" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Teacher Register
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="testMailPath?from=admin" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Admin Register
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="majorRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Major Register            
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="greadRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Grade Register           
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="academicYearRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Academic Year Register          
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="memberRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Member Register        
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="positionRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Position Register
              </p>
            </a>
          </li>
             <li class="nav-item">
            <a href="departmentRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Department Register
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="roleRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Role Register
              </p>
            </a>
          </li>
          
           
         
          </ul>
          </li>
       </ul>
       </nav>
       
           <nav class="mt-2">
           <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
             <li class="nav-item has-treeview">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-edit"></i>
              <p>
               Book Register Pages
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
          <li class="nav-item">
            <a href="selectBookGroupPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Book Register
               
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="bookEditionRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
               Book Edition Register          
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="bookGroupRegisterPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
                Book Group Register               
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="saveBookConfrimSubmitPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Book
              </p>
            </a>
          </li>
          </ul>
          </li>
          </ul>
          </nav>
          
            <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
             <li class="nav-item has-treeview ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
              Show Data Table
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
           <li class="nav-item">
            <a href="saveBookConfrimSubmitPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Book
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="showAllRentPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Rent List
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="showAllReturnPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Return List
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="showAllStudentPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Student
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="showAllAdminPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Admin
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="showAllTeacherPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              Show All Teacher
              </p>
            </a>
          </li>
          </ul>
         </li>
         </ul>
         </nav>
           <nav class="mt-2">
           <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
         
           <li class="nav-item has-treeview ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
              Export Excel
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
             <ul class="nav nav-treeview">
           <li class="nav-item">
            <a href="expRentByGroupPath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              RentList By Group
              </p>
            </a>
          </li>
           <li class="nav-item">
            <a href="expRentByGradePath" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>
              RentList By Gread
              </p>
            </a>
          </li>
          </ul>
            </li>
            </ul>
            </nav>
            
         </c:when>
         </c:choose> 
         
          </div>
          </aside>
         
          
          
         
        
      
        
      
   
