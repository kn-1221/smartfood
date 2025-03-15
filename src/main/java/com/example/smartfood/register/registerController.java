package com.example.smartfood.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class registerController {
    
    //初期表示
    @GetMapping("/register")
    public String init(){
        return "register.html";
    }
}
