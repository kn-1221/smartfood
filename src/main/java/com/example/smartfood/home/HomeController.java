package com.example.smartfood.home;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    
    @GetMapping("/home")
    public String init(){
        return "home";
    }
}
