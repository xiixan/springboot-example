package com.superface.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import com.superface.example.annotation.Log;
import com.superface.example.entity.Student;
import com.superface.example.repositories.StudentReposity;
import com.superface.example.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student
 * @author Ben
 * @descrition Student类控制器
 */
@RestController()
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentReposity studentReposity;
    
    @Resource(name="studentService")
    private StudentService studentService;

    @RequestMapping( value = "/all", method = RequestMethod.GET)
    public Student addStudent(String sno){
        Optional<Student> sutdentOpt = studentReposity.findById(sno);
        return sutdentOpt.get();
    }

    @Log("findList was Controllered") //在Controller 使用Aspect Around 会使Controller无返回
    @RequestMapping( value = "/jdbcall", method = RequestMethod.GET)
    public List<Map<String,Object>> findList(){
        List<Map<String, Object>> findList = studentService.findList();
        return findList;
    }
    
}