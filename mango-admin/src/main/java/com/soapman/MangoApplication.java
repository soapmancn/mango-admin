package com.soapman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
@MapperScan("com.soapman.mapper")
public class MangoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoApplication.class, args);
    }
}
