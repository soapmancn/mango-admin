package com.soapman.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.soapman.domain.LoginUser;
import com.soapman.entity.User;
import com.soapman.service.LoginService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Object login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }

        //如果认证通过了，使用userid生成一个jwt jwt存入redis 并返回
        LoginUser authUser = (LoginUser) authenticate.getPrincipal();
        String userId = String.valueOf(authUser.getUser().getId());

        Map<String, Object> jwtMap = new HashMap<>();
        jwtMap.put("userId", userId);

        String jwtToken = JWTUtil.createToken(jwtMap, authUser.getUser().getSalt().getBytes(StandardCharsets.UTF_8));

        //缓存60秒
        try {
            stringRedisTemplate.opsForValue().set("token:"+userId, JSON.toJSONString(authUser), 1, TimeUnit.HOURS);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("登录失败");
        }


        return jwtToken;
    }

    @Override
    public String loginOut() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //删除redis中的值
        stringRedisTemplate.delete("token:"+loginUser.getUser().getId());
        return "success";
    }
}
