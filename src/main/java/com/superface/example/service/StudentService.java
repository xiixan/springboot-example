package com.superface.example.service;

import java.util.List;
import java.util.Map;

import com.superface.example.entity.Student;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * StudentService
 */
@CacheConfig(cacheNames = "student")
public interface StudentService {

    int add(Student student);

    @CachePut(key = "#p0.sno")
    int update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    int delete(String id);
    List<Map<String,Object>> findList();

    @Cacheable(key = "#p0")
    Student findById(String id);

}