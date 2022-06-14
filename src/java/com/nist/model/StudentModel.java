/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.model;

/**
 *
 * @author shashi
 */
public class StudentModel {
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String phone;
    private int id;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String fname) {
        this.first_name = fname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public StudentModel(int id, String first_name, String last_name,String address, String email, String phone){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    
    public StudentModel(){
        
    }
}
