package com.soapman;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void setValue() {
        redisTemplate.opsForValue().set("day", "星期一");
        System.out.println(redisTemplate.opsForValue().get("day"));
    }

}
