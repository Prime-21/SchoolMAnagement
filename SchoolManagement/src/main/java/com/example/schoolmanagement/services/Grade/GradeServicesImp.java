/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.services.Grade;

import com.example.schoolmanagement.model.Grade;
import com.example.schoolmanagement.repositary.GradeRepositary;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prasad Kharat
 */

@Service
@Transactional
public class GradeServicesImp implements GradeServices
{

    @Autowired
    GradeRepositary gs;

    public Grade createGradedet(Grade g)
    {   
        return gs.save(g);
    }

    public Grade updateGrade(Grade g)
    {
        Optional <Grade> gradedb = this.gs.findById(g.getId());
        if (gradedb.isPresent()) {
            Grade GradeUpdate = gradedb.get();
            GradeUpdate.setId(g.getId());
            GradeUpdate.setAttend(g.getAttend());
            GradeUpdate.setMarks(g.getMarks());
            GradeUpdate.setGrade(g.getGrade());
            gs.save(GradeUpdate);
            return GradeUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + g.getId());
        }
    }

    public List<Grade> getAlldet()
    {
        return this.gs.findAll();
    }

    public Grade getGradebyid(int id)
    {
        Optional < Grade > GradeDb = this.gs.findById(id);
        if (GradeDb.isPresent()) {
            return GradeDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    public void deletebyid(int id)
    {
        Optional < Grade > productDb = this.gs.findById(id);

        if (productDb.isPresent()) {
            this.gs.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }   
}
