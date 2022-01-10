/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.Grade;

import com.example.schoolmanagement.model.Grade;
import java.util.List;

/**
 *
 * @author Prasad Kharat
 */

public interface GradeServices 
{
    Grade createGradedet(Grade g);

    Grade updateGrade(Grade g);

    List<Grade> getAlldet();

    Grade getGradebyid(int id);

    void deletebyid(int id);

}
