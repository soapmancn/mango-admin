package com.soapman.filter;


import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import com.soapman.domain.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String userId;
        try{
            userId = (String) JWTUtil.parseToken(token).getPayload().getClaim("userId");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String userInfo = stringRedisTemplate.opsForValue().get("token:"+userId);
        if (Objects.isNull(userInfo)){
            throw new RuntimeException("用户未登录");
        }
        LoginUser loginUser = JSON.parseObject(userInfo, LoginUser.class);

        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
