package com.soapman;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
public class SpringSecurityTest {

    @Resource
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void passWordEncoder() {

        String password = "123";
        String pass1 = passwordEncoder.encode(password);
        String pass2 = passwordEncoder.encode(password);
        Boolean result1 = passwordEncoder.matches(password, pass1);
        Boolean result2 = passwordEncoder.matches(password, pass2);
        System.out.println("password:123 pass1 encoder:" + pass1 + " result:" + result1);
        System.out.println("password:123 pass2 encoder:" + pass2 + " result:" + result2);
    }

}
