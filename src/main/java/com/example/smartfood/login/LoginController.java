package com.example.smartfood.login;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    
    @GetMapping("/login")
    public String init(){
        return "login";
    }
}
