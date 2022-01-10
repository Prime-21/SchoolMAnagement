/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.presenty;

import com.example.schoolmanagement.model.Marks;
import java.util.Map;

/**
 *
 * @author Prasad Kharat
 */

public interface PresentyServices 
{

    Map<String,Marks>  details();

    String insertpre(Marks m);

    String updatepre(Marks m,String id);

    String deletepre(Marks m,String id);

    Map<Marks,String> detailbyid(String id);
}
