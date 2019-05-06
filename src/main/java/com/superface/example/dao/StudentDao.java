package com.superface.example.dao;

import java.util.List;
import java.util.Map;

import com.superface.example.entity.Student;

/**
 * StudentDao
 */
public interface StudentDao {
    int add(Student student);
    int update(Student student);
    int delete(String id);
    List<Map<String,Object>> findList();
    Student findById(String id);
    
}