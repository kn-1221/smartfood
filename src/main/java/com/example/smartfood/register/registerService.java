package com.example.smartfood.register;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class RegisterService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final Logger logger = LoggerFactory.getLogger(RegisterService.class);
    //新規登録画面
    private final String REGISTER = "register/register";
    @Autowired
    private RegisterMapper registerMapper;
    
    @Transactional(rollbackFor = Exception.class) 
    public String userRegist(Model model, RegisterForm form, RedirectAttributes redirectAttributes) {
        //DB登録
        try {
            //同じユーザ名を検索
            int countUsername = registerMapper.countMatchedUsername(form);
            if(countUsername >= 1){
                model.addAttribute("errorMessage", "既に使用されているユーザ名です。");
                return REGISTER;
            }
            // パスワードをハッシュ化
            String hashedPassword = passwordEncoder.encode(form.getPassword());
            // フォームのパスワードをハッシュ済みに差し替え
            form.setPassword(hashedPassword);
            //登録処理
            int result = registerMapper.insertUser(form);

        if(result == 1){
            logger.info("登録完了");
        } else{
            logger.error("登録失敗");
            throw new Exception();
        }


        } catch (Exception e) {
            Map<Class<? extends Exception>, String> errorMessages = new HashMap<>();
            errorMessages.put(DuplicateKeyException.class, "このメールアドレスは既に登録されています。");
            errorMessages.put(DataIntegrityViolationException.class, "入力内容に誤りがあります。");
            errorMessages.put(CannotGetJdbcConnectionException.class, "データベースに接続できません。しばらくしてから再試行してください。");

            String errorMessage = errorMessages.getOrDefault(e.getClass(), "予期しないエラーが発生しました。");

            model.addAttribute("errorMessage", errorMessage);
            return REGISTER;
        }
        redirectAttributes.addFlashAttribute("username",form.getUsername());
        redirectAttributes.addFlashAttribute("email",form.getEmail());
        return "redirect:/registComplete";
    }
}
