package com.BankApplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping("/noticeDetails")
    public String getNoticeDetails(){
        return "NOTICE DETAILS FROM DATABASE";
    }
}
