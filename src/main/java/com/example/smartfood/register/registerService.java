package com.example.smartfood.register;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.smartfood.form.RegisterForm;

@Service
public class RegisterService {
    public String userRegist(Model model, RegisterForm form, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("userName",form.getUserName());
        redirectAttributes.addFlashAttribute("email",form.getEmail());
        return "redirect:/registComplete";
    }
}
