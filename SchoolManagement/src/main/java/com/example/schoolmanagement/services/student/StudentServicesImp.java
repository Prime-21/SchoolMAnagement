/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.student;

import com.example.schoolmanagement.model.Application;
import com.example.schoolmanagement.model.Student;
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
public class StudentServicesImp implements StudentServices
{

    @Autowired
    JdbcTemplate jdtemp;

    @Override
    public List alldetails()
    {
       String sql = "SELECT * FROM student";
            return jdtemp.queryForList(sql);
    }  

    @Override
    public String insertstud(Student s)
    {
        if (s.getName()== null || s.getDiv() == null || s.getClassteainch() == null) 
        {
            return "Please Insert data properly";
        } 
        else 
        {
            try 
            {
                String sql = "INSERT INTO student (id, name, divi, Classteainch, subject) VALUES (?, ?, ?, ?, ?)";
                jdtemp.update(sql, s.getId(), s.getName(), s.getDiv(), s.getClassteainch(),s.getSubject());
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
    public String updatestud(Student s)
    {
        try
        {
            String sql="UPDATE student set divi=?, Classteainch=? where id=?";
            jdtemp.update(sql,s.getDiv(),s.getClassteainch(),s.getId());
            return "Data Updated";
        }
        catch(Exception e)
        {
            if(s.getId()== null)
            {
                return "Please insert id properly"; 
            }
            return "Exception occured or id not found";
        }
    }

    @Override 
    public String deletestud(Student s)
    {
        try
        {
            String sql = "DELETE from student where id=?";
            int result = jdtemp.update(sql, s.getId());
            System.out.println("data deleted");
            return "Data deleted"+s.getId();
        }
        catch(Exception e)
        {
            if(s.getId()== null)
            {
                return "Please insert id properly"; 
            }
            return "Exception occured or id not found";
        }
    }
  
    @Override
    public List detailbyid(String id)
    {
       String sql = "SELECT * FROM student where id=?";
       return jdtemp.queryForList(sql,id);
    }
}
