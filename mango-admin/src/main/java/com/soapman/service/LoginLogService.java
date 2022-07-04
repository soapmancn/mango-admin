package com.soapman.service;

import com.soapman.entity.LoginLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统登录日志(LoginLog)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
public interface LoginLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LoginLog queryById(Long id);

    /**
     * 分页查询
     *
     * @param loginLog 筛选条件
     * @return 查询结果
     */
    Page<LoginLog> queryByPage(LoginLog loginLog, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    LoginLog insert(LoginLog loginLog);

    /**
     * 修改数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    LoginLog update(LoginLog loginLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
