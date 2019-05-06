package com.superface.example.repositories;

import java.util.List;

import com.superface.example.entity.Permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleReposity
 */
@Repository
public interface PermissionReposity extends JpaRepository<Permission,Integer> {

    List<Permission> findByName(String name);

}