/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.studid;

import com.example.schoolmanagement.model.Application;
import com.example.schoolmanagement.services.Grade.GradeServices;
import com.example.schoolmanagement.services.marks.MarksServices;
import com.example.schoolmanagement.services.presenty.PresentyServices;
import com.example.schoolmanagement.services.student.StudentServices;
import com.example.schoolmanagement.services.teacher.TeacherServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.x509.RDN;

/**
 *
 * @author Prasad Kharat
 */
@Service
@Transactional
public class StudidServicesImp implements StudidServices 
{

    @Autowired
    JdbcTemplate jdtemp;

    @Autowired
    RedisTemplate rd;
    
    @Autowired
    StudentServices ss;

    @Autowired
    TeacherServices ts;

    @Autowired
    MarksServices ms;

    @Autowired
    PresentyServices ps;

    @Autowired
    GradeServices gs;

    @Override
    public List detailsbyid(String id,String Classassign) 
    {
        String r="Student details";
        ArrayList result=new ArrayList();
        result.add(r);
        result.add(ss.detailbyid(id));
        result.add("Teacher details");
        result.add(ts.detailbyid(Classassign));
        result.add("Marks details");
        result.add(ms.detailbyid(id));
        result.add("Percentage details");
        result.add(ps.detailbyid(id));
        result.add(" grade");
        int idi=Integer.parseInt(id);
        result.add(gs.getGradebyid(idi));        
        result.add("Personal Details");
        String sql="SELECT * from app where id = ?";
        result.add(jdtemp.queryForList(sql,id)); 
        return result;
    }
    
    @Override
    public List showdata(Application a)
    {
        String sql="SELECT * FROM app";
        List result=jdtemp.queryForList(sql);
        return result;
    }

    @Override  
    public String adddata(Application a)
    {
        String sql="INSERT INTO app (name,address,bg,gender) VALUES(?,?,?,?)";
        jdtemp.update(sql,a.getName(),a.getAddress(),a.getBG(),a.getGender());
        String sql1="INSERT INTO student (name, divi, Classteainch, subject) VALUES(?,?,?,?)";
        jdtemp.update(sql1,a.getName(), "A", "unknown", "all");
        return "Data added";
    }

    @Override
    public List lc(String id,String  grade) 
    {
        try 
        {
            String r="Student details";
            ArrayList result=new ArrayList();
            result.add(r);
            result.add(ss.detailbyid(id));
            String sql1="Delete from student where id=?";
            jdtemp.update(sql1,id);
            result.add("Marks details");
            result.add(ms.detailbyid(id));
            rd.opsForHash().delete("Marks", id);
            result.add("Percentage details");
            result.add(ps.detailbyid(id));
            rd.opsForHash().delete("Presenty", id);
            result.add(" grade");
            int idi=Integer.parseInt(id);
            result.add(gs.getGradebyid(idi));
            String sql="SELECT * from app where id = ?";
            result.add(jdtemp.queryForList(sql,id));
            String sql2="UPDATE app set grade=? where id=?";
            jdtemp.update(sql2,grade,id);
            gs.deletebyid(idi);
            return result;
        } catch (Exception e) 
        {
            ArrayList result=new ArrayList();
            result.add("Data already deleted");
            return result;
        }
    } 
}
