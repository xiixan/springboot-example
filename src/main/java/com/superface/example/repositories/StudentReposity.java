package com.superface.example.repositories;

import com.superface.example.entity.Student;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StudentReposity
 * @author Ben
 * @Desc Student 存储库
 */
@CacheConfig(cacheNames = "student")
public interface StudentReposity extends JpaRepository<Student,String>{

    
}