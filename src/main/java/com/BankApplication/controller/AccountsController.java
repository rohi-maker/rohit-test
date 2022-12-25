package com.BankApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    @GetMapping("/accountDetails")
    public String getAccountDetails(){
        return "ACCOUNT DETAILS FROM DATABASE";
    }
}
