<%-- 
   Document   : student
   Created on : Apr 28, 2022, 6:59:58 AM
   Author     : shashi
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Add Student</title>
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
                        <li class="breadcrumb-item active"><span>Add Student</span></li>
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
                       
                <c:set var="msg" value='<%=request.getAttribute("studentExists")%>'></c:set>
                    <c:if test="${not empty msg}">
                        <h4 class="title text-center" style="color:red">${msg}</h4>
                    </c:if>
                        
               <form class="row g-3" method="post" action="student?action=add">
                  <div class="col-md-6">
                     <label for="firstname" class="form-label">First Name</label>
                     <input type="text" class="form-control" id="firstname" name="first_name" required>
                  </div>
                  <div class="col-md-6">
                     <label for="lastname" class="form-label">Last Name</label>
                     <input type="text" class="form-control" id="lastname" name="last_name" required>
                  </div>
                  <div class="col-md-6">
                     <label for="address" class="form-label">Address</label>
                     <input type="text" class="form-control" id="address" name="address">
                  </div>
                  <div class="col-md-6">
                     <label for="email" class="form-label">Email</label>
                     <input type="email" class="form-control" id="email" name="email">
                  </div>
                   <div class="col-md-6">
                     <label for="phone" class="form-label">Phone</label>
                     <input type="text" class="form-control" id="phone" name="phone">
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