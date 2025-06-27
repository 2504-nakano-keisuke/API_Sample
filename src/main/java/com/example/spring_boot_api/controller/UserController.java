package com.example.spring_boot_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_api.entity.User;
import com.example.spring_boot_api.exception.NotFoundException;
import com.example.spring_boot_api.repository.UserRepository;
import com.example.spring_boot_api.request.UserRequest;
import com.example.spring_boot_api.response.ErrorResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

   @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " is not found."));
    }

    @PostMapping
    public User save(@RequestBody @Valid UserRequest request) {
        User entity = new User();
        entity.setName(request.getName());
        return userRepository.save(entity);
    }
    
    @PutMapping("/{id}")
    public User update(@RequestBody UserRequest request,
                      @PathVariable("id") Integer id) {


       User entity = new User();
       entity.setId(id);
       entity.setName(request.getName());
       return userRepository.saveAndFlush(entity);
    }
   
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
       userRepository.deleteById(id);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        ErrorResponse response = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}