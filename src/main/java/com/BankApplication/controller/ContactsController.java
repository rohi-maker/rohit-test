package com.BankApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
    @GetMapping("/contactDetails")
    public String getContactDetails(){
        return "CONTACT DETAILS FROM DATABASE";
    }
}
