package com.example.mapper.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.beans.UserBean;

@Mapper
public interface UserMapper {
    Optional<UserBean> findByEmail(String email);
}
