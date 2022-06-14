<%-- 
   Document   : sidebar
   Created on : Apr 27, 2022, 8:07:20 AM
   Author     : shashi
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
   <div class="sidebar-brand d-none d-md-flex">
       <h2>NIST</h2>
   </div>
   <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
      <li class="nav-item">
         <a class="nav-link" href="dashboard.jsp">
            <svg class="nav-icon">
               <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
            </svg>
            Dashboard<span class="badge badge-sm bg-info ms-auto">NEW</span>
         </a>
      </li>
      <li class="nav-title">Student Info</li>
      <li class="nav-item">
         <a class="nav-link" href="student.jsp">
            <svg class="icon me-2">
               <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
            </svg>
            Add Student
         </a>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="student?action=display">
            <svg class="icon me-2">
               <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-credit-card"></use>
            </svg>
            Display Student
         </a>
      </li>
      <li class="nav-title">Course Info</li>
      <li class="nav-item">
         <a class="nav-link" href="course.jsp">
            <svg class="icon me-2">
               <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-book"></use>
            </svg>
            Add Course
         </a>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="course?action=display">
            <svg class="icon me-2">
               <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-file"></use>
            </svg>
            Display Course
         </a>
      </li>
   </ul>
   <button class="sidebar-toggler" type="button" data-coreui-toggle="unfoldable"></button>
</div>