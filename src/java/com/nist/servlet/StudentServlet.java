/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.nist.servlet;

import com.nist.dao.StudentDao;
import com.nist.model.StudentModel;
import java.io.IOException;
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
public class StudentServlet extends HttpServlet {

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
       if(request.getParameter("action").equals("display")){
             processRequest(request, response);
        }else if(request.getParameter("action").equals("delete")){
           int id = Integer.parseInt(request.getParameter("id"));
           boolean deleteStudentData =  StudentDao.delete(id);
           if(deleteStudentData){
             processRequest(request, response);
           }
        }else if(request.getParameter("action").equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<StudentModel> al = StudentDao.getStudentData(id);
            request.setAttribute("editstudent",al);
            RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
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
        
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        StudentModel sm = new StudentModel();
        sm.setFirst_name(first_name);
        sm.setLast_name(last_name);
        sm.setAddress(address);
        sm.setEmail(email);
        sm.setPhone(phone);
       if(request.getParameter("action").equals("add")){
           boolean studentExists = StudentDao.checkStudentExists(sm);
           if(studentExists){
            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            String msg = "Student email already registered.";
            request.setAttribute("studentExists", msg);
            rd.forward(request, response);
           }else{      
               boolean dataInsert = StudentDao.insertData(sm);
                if(dataInsert){
                     processRequest(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
                        String msg = "Sorry, something went wrong. Student not added.";
                        request.setAttribute("msg", msg);
                        rd.forward(request, response);
                }
           }
        
       }else if(request.getParameter("action").equals("update")){
           int id = Integer.parseInt(request.getParameter("id"));
                   sm.setId(id);
              boolean updateStudent = StudentDao.updateStudent(sm);
              if(updateStudent){
              processRequest(request, response);
              }else{
                  RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
                String msg = "Sorry, something went wrong. Student not updated.";
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
