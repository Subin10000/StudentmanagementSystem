/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.model;

/**
 *
 * @author shashi
 */
public class StudentCourseModel {
    private int id;
    private int sid;
    private int cid;
    private String first_name;
    private String last_name;
    private String course_name;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public StudentCourseModel( String first_name, String last_name, String course_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.course_name = course_name;
    }

    public StudentCourseModel(int id, int sid, int cid) {
        this.id = id;
        this.sid = sid;
        this.cid = cid;
    }

    public StudentCourseModel() {
    }
    
    
}
