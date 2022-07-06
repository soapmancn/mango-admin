package com.soapman.service;

import com.soapman.entity.User;

public interface LoginService {
    Object login(User user);

    String loginOut();
}
