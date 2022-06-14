<%-- 
    Document   : editcourse
    Created on : May 9, 2022, 10:18:34 PM
    Author     : shashi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Edit Course</title>
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
                        <li class="breadcrumb-item active"><span>Edit Course</span></li>
                      </ol>
                    </nav>
                </div>
          </header>          
         <div class="body flex-grow-1 px-3">
            <div class="container-lg">
                 <c:set var="msg" value='<%=request.getAttribute("msg")%>'></c:set>
                    <c:if test="${not empty msg}">
                        <h4 class="title text-center" style="color:red">${msg}</h4>
                    </c:if>
                <form class="row g-3" method="post" action="course?action=update">
                  <input type="hidden" class="form-control" id="course" name="id" value="${editcourse.get(0).id}">
                    <div class="col-md-6">
                     <label for="course" class="form-label">Course Name</label>
                     <input type="text" class="form-control" id="course" name="course_name" value="${editcourse.get(0).name}">
                  </div>
                  <div class="col-md-6">
                     <label for="duration" class="form-label">Duration</label>
                     <input type="text" class="form-control" id="duration" name="duration" value="${editcourse.get(0).duration}">
                  </div>
                  <div class="col-md-6">
                     <label for="fee" class="form-label">Fee</label>
                     <input type="text" class="form-control" id="fee" name="fee" value="${editcourse.get(0).fee}">
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