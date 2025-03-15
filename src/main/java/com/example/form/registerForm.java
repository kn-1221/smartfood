package com.example.form;

import lombok.Data;

@Data
public class registerForm {
    //ユーザ名
    private String userName;
    //メールアドレス
    private String email;
    //パスワード
    private String password;
    //パスワード確認
    private String confirmPassword;
}
