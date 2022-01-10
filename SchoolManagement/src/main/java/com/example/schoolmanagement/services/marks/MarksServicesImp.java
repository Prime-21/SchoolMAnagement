/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.marks;

import com.example.schoolmanagement.model.Marks;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prasad Kharat
 */

@Service
@Transactional
public class MarksServicesImp implements MarksServices
{
    @Autowired
    RedisTemplate rd;

    @Override
    public Map<String,Marks>  details()
    {
        return  rd.opsForHash().entries("Marks");
    }

    @Override
    public String insertmarks(Marks m)
    {
        m=new Marks(m.getId(),m.getEnglish(),m.getScience(),m.getHindi(),m.getMarathi(),m.getPt());
        rd.opsForHash().put("Marks",m.getId(),m);
        return "Data Inserted";
    }

    @Override
    public String updatemarks(Marks m,String id)
    {
        m=new Marks(m.getId(),m.getEnglish(),m.getHindi(),m.getMarathi(),m.getScience(),m.getPt());
        rd.opsForHash().put("Marks",m.getId(),m);
        return "Data updated";
    }

    @Override
    public String deletemarks(Marks m)
    {
        rd.opsForHash().delete("Marks",m.getId());
        System.out.println("Data Deleted");
        return "Data Deleted";
    }

    @Override
    public Map<Marks,String> detailbyid(String id) 
    { 
        ObjectMapper o = new ObjectMapper();
        Map<Marks,String> props = o.convertValue(rd.opsForHash().get("Marks",id), Map.class);
        return props;
    }
}
