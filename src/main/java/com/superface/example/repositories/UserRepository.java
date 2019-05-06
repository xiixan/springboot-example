package com.superface.example.repositories;

import com.superface.example.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserNameAndPassword(String userName,String password);
}