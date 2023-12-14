package com.emirhanbaran.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    @GetMapping("")
    public String sayHello(){
        return  "HELLO WORLD!";
    }
}
