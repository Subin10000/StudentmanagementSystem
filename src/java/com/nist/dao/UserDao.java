/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.dao;

import com.nist.model.UserModel;
import com.nist.utils.DBConnection;
import com.nist.utils.PasswordEncryption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shashi
 */
public class UserDao {
        public static UserModel login(String username, String password) {
        Statement st = DBConnection.statementObject();
        String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                UserModel um = new UserModel(rs.getInt("id"),rs.getString("username"), rs.getString("password"), rs.getString("full_name"));
                return um;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error "+ e);
        }
        return null;
    }
public static void createAdmin(UserModel um){
    Statement st = DBConnection.statementObject(); 
    String checkUser = "SELECT * FROM users where username='admin'";
    try {
        ResultSet rs = st.executeQuery(checkUser);
        if (rs.next()) {
            System.out.println("User already exists");
        }else{
            String sql = "INSERT INTO users(full_name,username,password)VALUES('" + um.getFull_name() + "','"+um.getUsername()+"','"+um.getPassword()+"')";
        try {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Data not inserted" + e);
        }  
        }
    } catch (SQLException e) {
        System.out.println("Error "+ e);
    }
}

}
