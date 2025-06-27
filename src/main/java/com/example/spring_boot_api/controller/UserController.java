package com.example.spring_boot_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.repository.UserRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/users")
public class UserController {


   private final UserRepository userRepository;
   public UserController(UserRepository userRepository) {
       this.userRepository = userRepository;
   }
   @GetMapping
   public List<User> getAll() {
       return userRepository.findAll();
   }
}