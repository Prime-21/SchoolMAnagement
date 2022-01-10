/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.marks;

import com.example.schoolmanagement.model.Marks;
import java.util.Map;

/**
 *
 * @author Prasad Kharat
 */
public interface MarksServices 
{

    Map<String,Marks>  details();

    String insertmarks(Marks m);

    String updatemarks(Marks m,String id);

    String deletemarks(Marks m);

    Map<Marks,String> detailbyid(String id);
}
