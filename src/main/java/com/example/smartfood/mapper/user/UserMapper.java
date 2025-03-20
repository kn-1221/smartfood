package com.example.smartfood.mapper.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.smartfood.beans.UserBean;

@Mapper
public interface UserMapper {
    Optional<UserBean> findByEmail(String email);
}
