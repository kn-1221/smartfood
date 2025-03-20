package com.example.smartfood.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.smartfood.form.RegisterForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    //初期表示
    @GetMapping("/register")
    public String init(Model model, RegisterForm form){
        return "register/register";
    }

    @PostMapping("/register")
    public String userRegist(Model model, RegisterForm form, RedirectAttributes redirectAttributes) {
        return registerService.userRegist(model, form, redirectAttributes);
    }
    
    @GetMapping("/registComplete")
    public String complete(Model model) {
        return "register/registComplete";
    }
    
}
