/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nist.model;

/**
 *
 * @author shashi
 */
public class CourseModel {
    private int id;
    private String name;
    private String duration;
    private double fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public CourseModel(int id, String name, String duration, double fee) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    public CourseModel() {
    }
    
}
