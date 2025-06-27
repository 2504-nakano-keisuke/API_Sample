package com.example.spring_boot_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByOrderByIdDesc();
    List<User> findByNameContaining(String name);
    @Query("select t from User t where t.id = :id")
    Optional<User> findByIdOriginal(@Param("id") Integer id);
}

