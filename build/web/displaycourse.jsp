<%-- 
   Document   : displayStudent
   Created on : Apr 28, 2022, 7:15:57 AM
   Author     : shashi
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Display Course</title>
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
                        <li class="breadcrumb-item active"><span>Display Course</span></li>
                      </ol>
                    </nav>
                </div>
          </header>  
         <div class="body flex-grow-1 px-3">
            <div class="container-lg">
               <table class="table table-striped">
                  <thead>
                     <tr>
                        <th scope="col">Course Name</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Fee</th>
                        <th scope="col">Action</th>
                     </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="c" items="${course}">
                     <tr>
                           <td>${c.name}</td>
                           <td>${c.duration}</td>
                           <td>${c.fee}</td>
                           <td> <a href="course?action=delete&id=${c.id}">Delete</a> &nbsp;
                            <a href="course?action=update&id=${c.id}">Edit</a></td>
                      </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
         </div>
         <%@include file="footer.jsp" %>
      </div>
   </body>
   <!-- CoreUI and necessary plugins-->
   <%@include file="footerScript.jsp" %>
</html>