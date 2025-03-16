package com.example.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.beans.UserBean;
import com.example.mapper.user.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("ログイン試行: {}", email);

        Optional<UserBean> optionalUser = userMapper.findByEmail(email);

        if (optionalUser.isEmpty()) {
            logger.warn("ログイン失敗: ユーザー '{}' が見つかりません", email);
            throw new UsernameNotFoundException("ユーザー '" + email + "' が見つかりません");
        }

        UserBean userBean = optionalUser.get();
        logger.info("ログイン成功: {}", userBean.getEmail());

        return User.withUsername(userBean.getEmail())
                        .password(userBean.getPassword()) // DB に保存されているハッシュ化済みのパスワード
                        .build();
    }
    
}
