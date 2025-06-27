package com.example.spring_boot_api.request;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class UserRequest {
   @Pattern(regexp = ".{1,50}")
   private String name;
}

