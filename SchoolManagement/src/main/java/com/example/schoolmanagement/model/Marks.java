/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.model;

import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author Prasad Kharat
 */

@RedisHash("Marks")
public class Marks implements Serializable
{
    private String id;
    private String English;
    private String Science;
    private String Hindi;
    private String Marathi;
    private String pt;    

    public Marks(String id,String English, String Science, String Hindi, String Marathi, String pt) {
        this.id=id;
        this.English = English;
        this.Science = Science;
        this.Hindi = Hindi;
        this.Marathi = Marathi;
        this.pt = pt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public String getScience() {
        return Science;
    }

    public void setScience(String Science) {
        this.Science = Science;
    }

    public String getHindi() {
        return Hindi;
    }

    public void setHindi(String Hindi) {
        this.Hindi = Hindi;
    }

    public String getMarathi() {
        return Marathi;
    }

    public void setMarathi(String Marathi) {
        this.Marathi = Marathi;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }
   
}
