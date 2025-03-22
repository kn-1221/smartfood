package com.example.smartfood.register;

import lombok.Data;

@Data
public class RegisterForm {
    //ユーザ名
    private String username;
    //メールアドレス
    private String email;
    //パスワード
    private String password;
    //パスワード確認
    private String confirmPassword;
}
