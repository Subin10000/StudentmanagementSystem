<%-- 
    Document   : addstudentcourse
    Created on : May 9, 2022, 10:55:40 PM
    Author     : shashi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Add Student Course</title>
   </head>
   <body>
      <%@include file="sidebar.jsp" %>
      <div class="wrapper d-flex flex-column min-vh-100 bg-light">
          <header class="header header-sticky mb-4">
              <%@include file="header.jsp" %>
                <div class="container-fluid">
                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb my-0 ms-2">
                        <li class="breadcrumb-item">
                          <!-- if breadcrumb is single--><span>Home</span>
                        </li>
                        <li class="breadcrumb-item active"><span>Add Student Course</span></li>
                      </ol>
                    </nav>
                </div>
          </header>          
         <div class="body flex-grow-1 px-3">
            <div class="container-lg">
                <form class="row g-3" method="post" action="studentcourse?action=add">
                                      <input type="hidden" class="form-control" id="name" name="id"  value="${student.get(0).id}">
                    <div class="col-md-6">
                     <label for="name" class="form-label">Student Name</label>
                     <input type="text" class="form-control" id="name" name="name"  value="${student.get(0).first_name} ${student.get(0).last_name}" disabled>
                  </div>
                    <div class="col-md-6">
                    <label for="course" class="form-label">Course</label>
                 <select name="cid" id="course" class="form-select">
                    <c:forEach var="course" items="${course}">
                        <option value="${course.id}">${course.name}</option>
                    </c:forEach>
                </select>
                  </div>                
                  <div class="col-12">
                     <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
               </form>
            </div>
         </div>
         <%@include file="footer.jsp" %>
      </div>
   </body>
   <!-- CoreUI and necessary plugins-->
   <%@include file="footerScript.jsp" %>
</html>