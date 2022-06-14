/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.dao;

import com.nist.model.StudentModel;
import com.nist.utils.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author shashi
 */
public class StudentDao {
    public static boolean checkStudentExists(StudentModel student){
         String email = student.getEmail();          
         Statement st = DBConnection.statementObject(); 
        String emailCheck = "SELECT * FROM students where email = '" + email +"'";
        try {
           ResultSet rs = st.executeQuery(emailCheck);
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
    
    public static boolean insertData(StudentModel student){
        String firstName = student.getFirst_name();
        String lastName = student.getLast_name();
        String address = student.getAddress(); 
        String email = student.getEmail();             
        String phone = student.getPhone();             
        Statement st = DBConnection.statementObject(); 
        String sql = "INSERT INTO students(first_name,last_name,address,email,phone)VALUES('" + firstName + "','"+lastName+"','"+address+"','"+email+"','"+phone+"')";
        try {
            st.execute(sql);
            return true;
         } catch (SQLException e) {
            System.out.println("Data not inserted" + e);
        }
       return false;
    }
    
    public static ArrayList<StudentModel> displayStudent(){
        ArrayList<StudentModel> al = new ArrayList();
        Statement st = DBConnection.statementObject();
        String sql = "SELECT * FROM students";
        try{
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            al.add(new StudentModel(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"),rs.getString("email"),rs.getString("phone")));
          }
        }catch(SQLException e){
            System.out.println("Error");
        }
       return al; 
    }
    
     public static boolean delete(int id){
        Statement st = DBConnection.statementObject();
        String sql = "DELETE FROM students WHERE id ="+ id;
        try {
            st.executeUpdate(sql);
           return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
     
    public static ArrayList<StudentModel> getStudentData(int id){
        ArrayList<StudentModel> student = new ArrayList();
        Statement st = DBConnection.statementObject();
        String sql = "SELECT * FROM students WHERE id = "+id;
        try {
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            student.add(new StudentModel(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("address"),rs.getString("email"),rs.getString("phone")));
            } catch (SQLException e) {
            System.out.println("Data not fetch" + e);
        }
        return student;
    }
    
    public static boolean updateStudent(StudentModel sm){
        Statement st = DBConnection.statementObject();
        String sql = "UPDATE students set first_name ='"+sm.getFirst_name()+"',last_name='"+sm.getLast_name()+"',address='"+sm.getAddress()+"',email='"+sm.getEmail()+"',phone='"+sm.getPhone()+"' WHERE id="+sm.getId();
        try {
            st.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("data not updated" + e);
        }
        return false;
    }
}
