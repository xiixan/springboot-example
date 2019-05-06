package com.superface.example.repositories;

import java.util.List;

import com.superface.example.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleReposity
 */
@Repository
public interface RoleReposity extends JpaRepository<Role,Integer> {

    List<Role> findByName(String name);
}