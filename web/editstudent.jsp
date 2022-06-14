<%-- 
   Document   : student
   Created on : Apr 28, 2022, 6:59:58 AM
   Author     : shashi
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <base href="./">
      <%@include file="head.jsp" %>
      <title>Edit Student</title>
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
                        <li class="breadcrumb-item active"><span>Edit Student</span></li>
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
               <form class="row g-3" method="post" action="student?action=update">
                   <input type="hidden" class="form-control" name="id" value="${editstudent.get(0).id}" >
                   <div class="col-md-6">
                     <label for="firstname" class="form-label">First Name</label>
                     <input type="text" class="form-control" id="firstname" name="first_name" value="${editstudent.get(0).first_name}" required>
                  </div>
                  <div class="col-md-6">
                     <label for="lastname" class="form-label">Last Name</label>
                     <input type="text" class="form-control" id="lastname" name="last_name" value="${editstudent.get(0).last_name}" required>
                  </div>
                  <div class="col-md-6">
                     <label for="address" class="form-label">Address</label>
                     <input type="text" class="form-control" id="address" name="address" value="${editstudent.get(0).address}">
                  </div>
                  <div class="col-md-6">
                     <label for="email" class="form-label">Email</label>
                     <input type="email" class="form-control" id="email" name="email" value="${editstudent.get(0).email}">
                  </div>
                   <div class="col-md-6">
                     <label for="phone" class="form-label">Phone</label>
                     <input type="text" class="form-control" id="phone" name="phone" value="${editstudent.get(0).phone}">
                  </div>
                  <div class="col-12">
                     <button type="submit" class="btn btn-primary">Update</button>
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