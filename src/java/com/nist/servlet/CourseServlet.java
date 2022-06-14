/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nist.servlet;

import com.nist.dao.CourseDao;
import com.nist.model.CourseModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author shashi
 */
public class CourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<CourseModel> al = CourseDao.displayCourse();
        request.setAttribute("course", al);
        RequestDispatcher rd = request.getRequestDispatcher("displaycourse.jsp");
        rd.forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          if(request.getParameter("action").equals("display")){
             processRequest(request, response);
        }else if(request.getParameter("action").equals("delete")){
           int id = Integer.parseInt(request.getParameter("id"));
           boolean deleteCourseData =  CourseDao.delete(id);
           if(deleteCourseData){
             processRequest(request, response);
           }
        }else if(request.getParameter("action").equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<CourseModel> al = CourseDao.getCourseData(id);
            request.setAttribute("editcourse",al);
            RequestDispatcher rd = request.getRequestDispatcher("editcourse.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String course_name = request.getParameter("course_name");
        String duration = request.getParameter("duration");
        Double fee = Double.parseDouble(request.getParameter("fee"));
        CourseModel cm = new CourseModel();
        cm.setName(course_name);
        cm.setDuration(duration);
        cm.setFee(fee);
        if(request.getParameter("action").equals("add")){
           boolean studentExists = CourseDao.checkCourseExists(cm);
           if(studentExists){
            RequestDispatcher rd = request.getRequestDispatcher("course.jsp");
            String msg = "Course already registered.";
            request.setAttribute("courseExists", msg);
            rd.forward(request, response);
           }else{      
               boolean dataInsert = CourseDao.insertData(cm);
                if(dataInsert){
                     processRequest(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("course.jsp");
                        String msg = "Sorry, something went wrong. Course not added.";
                        request.setAttribute("msg", msg);
                        rd.forward(request, response);
                }
           }
         }else if(request.getParameter("action").equals("update")){
           int id = Integer.parseInt(request.getParameter("id"));
                   cm.setId(id);
              boolean updateCourse = CourseDao.updateCourse(cm);
              if(updateCourse){
              processRequest(request, response);
              }else{
                  RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
                String msg = "Sorry, something went wrong. Course not updated.";
                request.setAttribute("msg", msg);
                rd.forward(request, response);
              }
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
