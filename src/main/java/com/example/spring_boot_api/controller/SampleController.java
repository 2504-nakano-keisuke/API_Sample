package com.example.spring_boot_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SampleController {


   @GetMapping("/sample")
   public String helloWorld() {
       return "Hello World";
   }
}