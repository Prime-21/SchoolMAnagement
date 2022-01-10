/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.teacher;

import com.example.schoolmanagement.model.Teacher;
import java.util.List;

/**
 *
 * @author Prasad Kharat
 */
public interface TeacherServices 
{

    List<Teacher> alldetails();

    String inserttea(Teacher t);

    String updatetea(Teacher t);

    String deletetea(Teacher t);

    List detailbyid(String Classassign);
}
