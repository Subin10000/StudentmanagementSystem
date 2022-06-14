/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shashi
 */
public class DBConnection {
     public static Statement statementObject(){
      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not Loaded");
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system","root","root");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            System.out.println("Database not Connected");
        }
        Statement st = null;
        try {
            st = con.createStatement();
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return st;              
    }

}
