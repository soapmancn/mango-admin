package com.soapman.controller;

import com.soapman.core.http.HttpResult;
import com.soapman.entity.User;
import com.soapman.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "登录接口")
@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("in")
    public HttpResult login(@RequestBody User user){
        return HttpResult.ok(loginService.login(user));
    }


    @ApiOperation("登出")
    @GetMapping("out")
    public HttpResult logOut() {
        return HttpResult.ok(loginService.loginOut());
    }
}
