package com.BankApplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/loanDetails")
    public String getLoanDetails(){
        return "LOAN DETAILS FROM DATABASE";
    }
}
