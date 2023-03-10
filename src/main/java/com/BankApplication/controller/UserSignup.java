package com.BankApplication.controller;

import com.BankApplication.entity.Customer;
import com.BankApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignup {
    @Autowired
    public CustomerRepository repository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedObject= repository.save(customer);
        if(savedObject==null || savedObject.getId()<1){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("USER NOT CREATED");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("USER REGISTERED SUCCESSFULLY");
    }
}
