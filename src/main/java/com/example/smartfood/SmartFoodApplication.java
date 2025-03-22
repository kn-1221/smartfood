package com.example.smartfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.smartfood")
public class SmartFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartFoodApplication.class, args);
	}

}
