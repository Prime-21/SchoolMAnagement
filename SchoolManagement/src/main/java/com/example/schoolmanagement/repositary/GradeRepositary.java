/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.repositary;

import com.example.schoolmanagement.model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Prasad Kharat
 */
public interface GradeRepositary extends MongoRepository<Grade, Integer>
{
    
}
