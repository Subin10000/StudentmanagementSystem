<%-- 
    Document   : displaystudentcourse
    Created on : May 9, 2022, 11:25:29 PM
    Author     : shashi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Display Student Course</title>
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
                        <li class="breadcrumb-item active"><span>Display Student Course</span></li>
                      </ol>
                    </nav>
                </div>
          </header>  
         <div class="body flex-grow-1 px-3">
            <div class="container-lg">
               <table class="table table-striped">
                  <thead>
                     <tr>
                        <th scope="col">Firstname</th>
                        <th scope="col">Lastname</th>
                        <th scope="col">Course</th>
                    </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="s" items="${studentcourse}">
                     <tr>
                           <td>${s.first_name}</td>
                           <td>${s.last_name}</td>                          
                           <td>${s.course_name}</td>                                             
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