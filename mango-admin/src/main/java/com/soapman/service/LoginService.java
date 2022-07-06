package com.soapman.service;

import com.soapman.core.http.HttpResult;
import com.soapman.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    HttpResult login(LoginVo user, HttpServletRequest request);

    HttpResult loginOut();
}
