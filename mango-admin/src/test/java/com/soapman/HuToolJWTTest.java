package com.soapman;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class HuToolJWTTest {

    @Test
    public void JwtTest() {
        //创建
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };
        String token = JWTUtil.createToken(map, "1234".getBytes());
        System.out.println("token:" + token);

        //解析
        final JWT jwt = JWTUtil.parseToken(token);
        System.out.println("jwt:" + jwt.getPayload().getClaim("uid"));

        //验证
        System.out.println("验证结果:" + JWTUtil.verify(token, "1234".getBytes()));
    }

}
