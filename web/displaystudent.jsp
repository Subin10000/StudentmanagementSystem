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
      <title>Display Student</title>
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
                        <li class="breadcrumb-item active"><span>Display Student</span></li>
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
                        <th scope="col">Address</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                       <th scope="col">Action</th>
                       <th scope="col">Add Student's Course</th>
                       <th scope="col">View Student's Course</th>

                    </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="s" items="${student}">
                     <tr>
                           <td>${s.first_name}</td>
                           <td>${s.last_name}</td>
                           <td>${s.address}</td>
                           <td>${s.email}</td>
                           <td>${s.phone}</td>
                           <td> <a href="student?action=delete&id=${s.id}">Delete</a></td>
                           <td> <a href="student?action=update&id=${s.id}">Edit</a></td>
                           <td><a href="studentcourse?action=add&sid=${s.id}">Add</a></td>
                           <td><a href="studentcourse?action=display&sid=${s.id}">View</a></td>
                                             
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