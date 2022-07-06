package com.soapman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soapman.domain.LoginUser;
import com.soapman.entity.User;
import com.soapman.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user = userService.getOne(new QueryWrapper<User>().eq("name", username));
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        //查询用户权限
        Set<String> permissions = userService.findPermissions(username);

        return new LoginUser(user, permissions);
    }

}
