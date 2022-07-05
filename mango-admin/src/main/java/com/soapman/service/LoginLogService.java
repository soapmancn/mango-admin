package com.soapman.service;

import com.soapman.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统登录日志(LoginLog)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface LoginLogService extends IService<LoginLog> {

    /**
     * 分页查询
     *
     * @param loginLog
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<LoginLog> queryByPage(LoginLog loginLog, Integer pageNum, Integer pageSize);

}
