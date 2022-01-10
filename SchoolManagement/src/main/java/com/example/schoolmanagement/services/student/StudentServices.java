/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.student;

import com.example.schoolmanagement.model.Student;
import java.util.List;

/**
 *
 * @author Prasad Kharat
 */

public interface StudentServices 
{
    List<Student> alldetails();

    String insertstud(Student s);

    String updatestud(Student s);

    String deletestud(Student s);

    List detailbyid(String id);
}
