/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.model;

/**
 *
 * @author Prasad Kharat
 */


public class Student 
{
    private String id;
    private String name;
    private String div;
    private String classteainch;
    private String subject;

    public Student(String id, String name, String div, String classteainch,String subject) {
        this.id = id;
        this.name = name;
        this.div = div;
        this.classteainch = classteainch;
        this.subject=subject;
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

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public String getClassteainch() {
        return classteainch;
    }

    public void setClassteainch(String classteainch) {
        this.classteainch = classteainch;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubjects(String subject) {
        this.subject = subject;
    }
 
}
