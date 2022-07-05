package com.soapman.service;

import com.soapman.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户管理(User)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询
     *
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> queryByPage(User user, Integer pageNum, Integer pageSize);

}
