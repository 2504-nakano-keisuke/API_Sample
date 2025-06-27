package com.example.spring_boot_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

