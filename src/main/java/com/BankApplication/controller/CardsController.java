package com.BankApplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/cardsDetails")
    public String getCardsDetails(){
        return "CARDS DETAILS FROM DATABASE";
    }
}
