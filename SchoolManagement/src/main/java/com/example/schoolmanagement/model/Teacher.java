/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.model;

/**
 *
 * @author Prasad Kharat
 */

public class Teacher 
{
    private String id;
    private String name;
    private String SubTeach;
    private String claassign;

    public Teacher(String id, String name, String SubTeach, String claassign) {
    this.id = id;
        this.name = name;
        this.SubTeach = SubTeach;
        this.claassign = claassign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTeach() {
        return SubTeach;
    }

    public void setSubTeach(String SubTeach) {
        this.SubTeach = SubTeach;
    }

    public String getClaassign() {
        return claassign;
    }

    public void setClaassign(String claassign) {
        this.claassign = claassign;
    }

  
}
