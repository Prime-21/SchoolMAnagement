/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.teacher;

import com.example.schoolmanagement.model.Teacher;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prasad Kharat
 */

@Service
@Transactional
public class TeacherServicesImp implements TeacherServices
{
    @Autowired
    JdbcTemplate jdtemp;

    @Override
    public List alldetails()
    {
       String sql = "SELECT * FROM teacher";
            return jdtemp.queryForList(sql);
    }  

    @Override
    public String inserttea(Teacher t)
    {
        if (t.getName()== null || t.getSubTeach()== null || t.getClaassign() == null) 
        {
            return "Please Insert data properly";
        } 
        else 
        {
            try 
            {
                String sql = "INSERT INTO teacher (id, name, Subteach, classassign) VALUES (?, ?, ?, ?)";
                jdtemp.update(sql, t.getId(), t.getName(), t.getSubTeach(), t.getClaassign());
                System.out.println("Data Inserted");                
                return "Data Inserted";
            } 
            catch (Exception e) 
            {
                String a = e.toString();
                return a;
            }
        }
    }

    @Override
    public String updatetea(Teacher t)
    {
        try
        {
            String sql="UPDATE teacher set Subteach=?, classassign=? where id=?";
            jdtemp.update(sql,t.getSubTeach(),t.getClaassign(),t.getId());
            return "Data Updated";
        }
        catch(Exception e)
        {
            if(t.getId()== null)
            {
                return "Please insert id properly"; 
            }
            return "Exception occured or id not found";
        }    }

    @Override 
    public String deletetea(Teacher t)
    {
        try
        {
            String sql = "DELETE from teacher where id=?";
            int result = jdtemp.update(sql, t.getId());
            System.out.println("data deleted");
            return "Data deleted"+t.getId();
        }
        catch(Exception e)
        {
            if(t.getId()== null)
            {
                return "Please insert id properly"; 
            }
            return "Exception occured or id not found";
        }
    } 

    @Override
    public List detailbyid(String Classassign)
    {
       String sql = "SELECT name,Subteach,classassign FROM teacher where classassign=?";
            return jdtemp.queryForList(sql, Classassign);
    } 
}
