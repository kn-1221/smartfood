package com.example.smartfood.register;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    //DB登録
    int insertUser(RegisterForm form);

    //ユーザ名の重複確認
    int countMatchedUsername(RegisterForm form);
}
