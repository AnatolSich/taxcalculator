package com.example.taxcalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goHome(){
        return "index";
    }

    @GetMapping("/goToTax")
    public String goToTax(){
        return "result";
    }
}
