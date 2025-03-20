package com.example.smartfood.form;

import lombok.Data;

@Data
public class RegisterForm {
    //ユーザ名
    private String userName;
    //メールアドレス
    private String email;
    //パスワード
    private String password;
    //パスワード確認
    private String confirmPassword;
}
