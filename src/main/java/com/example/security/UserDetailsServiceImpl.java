package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.beans.UserBean;
import com.example.mapper.user.UserMapper;

public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserMapper userMapper;

    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserBean userBean = userMapper.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません") );

        return User.withUsername(userBean.getEmail())
                        .password(userBean.getPassword()) // DB に保存されているハッシュ化済みのパスワード
                        .build();
    }
    
}
