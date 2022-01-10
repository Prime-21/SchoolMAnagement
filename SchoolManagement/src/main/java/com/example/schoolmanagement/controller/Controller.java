/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Application;
import com.example.schoolmanagement.model.Grade;
import com.example.schoolmanagement.model.Marks;
import com.example.schoolmanagement.model.Student;
import com.example.schoolmanagement.model.Teacher;
import com.example.schoolmanagement.services.Grade.GradeServices;
import com.example.schoolmanagement.services.marks.MarksServices;
import com.example.schoolmanagement.services.presenty.PresentyServices;
import com.example.schoolmanagement.services.student.StudentServices;
import com.example.schoolmanagement.services.studid.StudidServices;
import com.example.schoolmanagement.services.teacher.TeacherServices;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Prasad Kharat
 */

@RestController
public class Controller 
{
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

    @Autowired
    StudidServices si;

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity <List<Student>> getallStudent()
    {
        return ResponseEntity.ok().body(ss.alldetails());
    }

    @RequestMapping(value = "/student/insert", method = RequestMethod.POST, consumes = "application/json")
    public String insert(@RequestBody Student s) 
    {
        return ss.insertstud(s);
    } 

    @RequestMapping(value = "/student/update", method = RequestMethod.POST, consumes = "application/json")
    public String update(@RequestBody Student s) 
    {
        return ss.updatestud(s);
    }

    @RequestMapping(value = "/student/delete", method = RequestMethod.POST, consumes = "application/json")
    public String delete(@RequestBody Student s) 
    {
        return ss.deletestud(s);
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Teacher>> insertteacher() 
    {
        return ResponseEntity.ok().body(ts.alldetails());
    }

    @RequestMapping(value = "/teacher/insert", method = RequestMethod.POST, consumes = "application/json")
    public String insertteach(@RequestBody Teacher s) 
    {
        return ts.inserttea(s);
    }  

    @RequestMapping(value = "/teacher/update", method = RequestMethod.POST, consumes = "application/json")
    public String update(@RequestBody Teacher s) 
    {
        return ts.updatetea(s);
    }

    @RequestMapping(value = "/teacher/delete", method = RequestMethod.POST, consumes = "application/json")
    public String delete(@RequestBody Teacher s) 
    {
        return ts.deletetea(s);
    }

    @RequestMapping(value = "/marks", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Marks> allmarks() 
    {
        return ms.details();
    }

    @RequestMapping(value = "/marks/insert", method = RequestMethod.POST, consumes = "application/json")
    public String insertmarks(@RequestBody Marks m) 
    {
        return ms.insertmarks(m);
    }

    @RequestMapping(value = "/marks/update", method = RequestMethod.POST, consumes = "application/json")
    public String updatemarks(@RequestBody Marks m) 
    {
        return ms.updatemarks(m,m.getId());
    }

    @RequestMapping(value = "/marks/delete", method = RequestMethod.POST, consumes = "application/json")
    public String deletemarks(@RequestBody Marks m) 
    {
        return ms.deletemarks(m);
    }

    @RequestMapping(value = "/presenty", method = RequestMethod.GET, produces = "application/json")
    public Map<String,Marks> allpredet() 
    {
        return ps.details();
    }

    @RequestMapping(value = "/presenty/insert", method = RequestMethod.POST, consumes = "application/json")
    public String insertpre(@RequestBody Marks m) 
    {
        return ps.insertpre(m);
    }

    @RequestMapping(value = "/presenty/update", method = RequestMethod.POST, consumes = "application/json")
    public String updatepre(@RequestBody Marks m) 
    {
        return ps.updatepre(m,m.getId());
    }

    @RequestMapping(value = "/presenty/delete", method = RequestMethod.POST, consumes = "application/json")
    public String deletepre(@RequestBody Marks m) 
    {
        return ps.deletepre(m,m.getId());
    }

    @GetMapping("/grade")
    public ResponseEntity < List < Grade >> getAllGrade() {
        return ResponseEntity.ok().body(gs.getAlldet());
    }

    @GetMapping("/grade/{id}")
    public ResponseEntity < Grade > getGradeById(@PathVariable int id) 
    {
        return ResponseEntity.ok().body(gs.getGradebyid(id));
    }

    @PostMapping("/grade")
    public ResponseEntity < Grade > createProduct(@RequestBody Grade u) 
    {
        return ResponseEntity.ok().body(this.gs.createGradedet(u));
    }

    @PutMapping("/grade/{id}")
    public ResponseEntity < Grade > updateProduct(@PathVariable int id, @RequestBody Grade g) 
    {
        g.setId(id);
        return ResponseEntity.ok().body(this.gs.updateGrade(g));
    }

    @DeleteMapping("/grade/{id}")
    public HttpStatus deleteProduct(@PathVariable int id) {
        this.gs.deletebyid(id);
        return HttpStatus.OK;
    }

    @GetMapping(value="/studid/{id}/{Classassign}")
    public List getdetailsid(@PathVariable String id,@PathVariable String Classassign)
    {
        return si.detailsbyid(id,Classassign);
    } 

    @GetMapping(value="/application")
    public List showdata(@RequestBody Application a)
    {
        return si.showdata(a);
    }

    @RequestMapping(value="/application",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public String adddata(@RequestBody Application a)
    {
        return si.adddata(a);
    }

    @GetMapping(value="/lc/{id}/{grade}")
    public List leaving(@PathVariable String id, @PathVariable String grade)
    {
        return si.lc(id,grade);
    }  
}
