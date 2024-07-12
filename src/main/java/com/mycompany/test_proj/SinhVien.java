/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_proj;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author Hieu
 */

public class SinhVien {
    private String name;
    private int ID;
    private double mark;

    // Default constructor
    public SinhVien() {
    }

    // Constructor with parameters
    @JsonCreator
    public SinhVien(@JsonProperty("name") String name, @JsonProperty("ID") int ID, @JsonProperty("mark") double mark) {
        this.name = name;
        this.ID = ID;
        this.mark = mark;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    // Method to print student info
    public void getSV() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Mark: " + mark);
    }
}
