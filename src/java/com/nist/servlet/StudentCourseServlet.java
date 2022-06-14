/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nist.servlet;

import com.nist.dao.CourseDao;
import com.nist.dao.StudentCourseDao;
import com.nist.dao.StudentDao;
import com.nist.model.CourseModel;
import com.nist.model.StudentCourseModel;
import com.nist.model.StudentModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shashi
 */
public class StudentCourseServlet extends HttpServlet {

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
        ArrayList<StudentModel> al = StudentDao.displayStudent();
        request.setAttribute("student", al);
        RequestDispatcher rd = request.getRequestDispatcher("displaystudent.jsp");
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
          if(request.getParameter("action").equals("add")){
        int sid = Integer.parseInt(request.getParameter("sid"));
        request.setAttribute("sid", sid);
         ArrayList<StudentModel> alist = StudentDao.getStudentData(sid);
            request.setAttribute("student",alist);
        ArrayList<CourseModel> al = CourseDao.displayCourse();
        request.setAttribute("course", al);
        RequestDispatcher rd = request.getRequestDispatcher("addstudentcourse.jsp");
        rd.forward(request,response);
    }else if(request.getParameter("action").equals("display")){
        int sid = Integer.parseInt(request.getParameter("sid"));
         ArrayList<StudentCourseModel> al = StudentCourseDao.displayStudentCourse(sid);
        request.setAttribute("studentcourse", al);
        RequestDispatcher rd = request.getRequestDispatcher("displaystudentcourse.jsp");
        rd.forward(request,response);
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
        int sid = Integer.parseInt(request.getParameter("id"));
      int cid = Integer.parseInt(request.getParameter("cid"));
        System.out.println(sid+"Hello ids"+cid);
      StudentCourseModel sm = new StudentCourseModel();
      sm.setSid(sid);
      sm.setCid(cid);
      if(request.getParameter("action").equals("add")){
          StudentCourseDao.insert(sm);
          processRequest(request,response);
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
