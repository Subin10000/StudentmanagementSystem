/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.dao;

import com.nist.model.StudentCourseModel;
import com.nist.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shashi
 */
public class StudentCourseDao {
        public static void insert(StudentCourseModel sm){
        Statement st = DBConnection.statementObject();
        String sql = "INSERT INTO student_courses(sid,cid)VALUES("+sm.getSid()+","+sm.getCid()+")";
        try {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("data not inserted "+e);
        }
    }
     public static ArrayList<StudentCourseModel> displayStudentCourse(int studentId){
        ArrayList<StudentCourseModel> al = new ArrayList();
        Statement st = DBConnection.statementObject();
        String sql ="SELECT s.first_name, s.last_name, c.name FROM courses c "
                + "INNER JOIN student_courses sc ON c.id = sc.cid INNER JOIN students s ON sc.sid = s.id " 
                +"WHERE sc.sid ="+studentId +" ORDER BY c.name";
         System.out.println(sql);
        try{
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            al.add(new StudentCourseModel(rs.getString("first_name"),rs.getString("last_name"),rs.getString("name")));
          }
        }catch(SQLException e){
            System.out.println("Error"+e);
        }
       return al; 
    }
       
        
}
