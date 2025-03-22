package com.example.smartfood.login;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Optional<UserBean> findByEmail(String email);
}
