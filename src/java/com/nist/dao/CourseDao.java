/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.dao;

import com.nist.model.CourseModel;
import com.nist.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shashi
 */
public class CourseDao {
     public static ArrayList<CourseModel> displayCourse(){
        ArrayList<CourseModel> al = new ArrayList();
        Statement st = DBConnection.statementObject();
        String sql = "SELECT * FROM courses";
        try{
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            al.add(new CourseModel(rs.getInt("id"),rs.getString("name"),rs.getString("duration"),rs.getDouble("fee")));
          }
        }catch(SQLException e){
            System.out.println("Error");
        }
       return al; 
    }
   public static boolean checkCourseExists(CourseModel course){
         String name = course.getName();          
         Statement st = DBConnection.statementObject(); 
        String nameCheck = "SELECT * FROM courses where name = '" + name +"'";
        try {
           ResultSet rs = st.executeQuery(nameCheck);
            if(rs.next()){
            return true;
            }else{
                return false;
            }
           } catch (SQLException e) {
            System.out.println("Error "+ e);
        }
           return false;
    }
    public static boolean insertData(CourseModel course){
        String name = course.getName();
        String duration = course.getDuration();
        Double fee = course.getFee();             
        Statement st = DBConnection.statementObject(); 
        String sql = "INSERT INTO courses(name,duration,fee)VALUES('" + name + "','"+duration+"','"+fee+"')";
        try {
            st.execute(sql);
            return true;
         } catch (SQLException e) {
            System.out.println("Data not inserted" + e);
        }
       return false;
    }
    public static boolean delete(int id){
        Statement st = DBConnection.statementObject();
        String sql = "DELETE FROM courses WHERE id ="+ id;
        try {
            st.executeUpdate(sql);
           return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
     
    public static ArrayList<CourseModel> getCourseData(int id){
        ArrayList<CourseModel> course = new ArrayList();
        Statement st = DBConnection.statementObject();
        String sql = "SELECT * FROM courses WHERE id = "+id;
        try {
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            course.add(new CourseModel(rs.getInt("id"),rs.getString("name"),rs.getString("duration"),rs.getDouble("fee")));
            } catch (SQLException e) {
            System.out.println("Data not fetch" + e);
        }
        return course;
    }
    
    public static boolean updateCourse(CourseModel cm){
        Statement st = DBConnection.statementObject();
        String sql = "UPDATE courses set name ='"+cm.getName()+"',duration='"+cm.getDuration()+"',fee='"+cm.getFee()+"' WHERE id="+cm.getId();
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("data not updated" + e);
        }
        return false;
    }

}
