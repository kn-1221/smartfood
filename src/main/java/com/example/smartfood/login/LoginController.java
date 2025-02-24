package com.example.smartfood.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // ログイン画面表示(GETリクエスト)
    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login"; // login.htmlを表示
    }

    // ログイン処理(POSTリクエスト)
    @PostMapping("/login")
    public String loginProcess(@RequestParam String username,@RequestParam String password,Model model)
    {
        //とりあえずIDとPASS両方"a"でログイン可能
        if ("a".equals(username) && "a".equals(password)) {
            // 認証成功 → ホーム画面（後述のhome.html）へ遷移
            return "home/home";
        } else {
            // 認証失敗 → ログイン画面に戻りエラー表示
            model.addAttribute("error", "ユーザー名またはパスワードが間違っています");
            return "login/login";
        }
    }
}
