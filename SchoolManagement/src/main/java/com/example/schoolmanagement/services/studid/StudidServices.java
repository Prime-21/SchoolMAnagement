/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.studid;
import com.example.schoolmanagement.model.Application;
import com.example.schoolmanagement.model.Student;
import java.util.List;

/**
 *
 * @author Prasad Kharat
 */
public interface StudidServices 
{

    List<Object> detailsbyid(String id,String Classassign);

    List<Application> showdata(Application a);

    String adddata(Application a);

    List<Object> lc(String id,String grade);

}
