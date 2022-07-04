package com.soapman.service.impl;

import com.soapman.entity.LoginLog;
import com.soapman.dao.LoginLogDao;
import com.soapman.service.LoginLogService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 系统登录日志(LoginLog)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    @Resource
    private LoginLogDao loginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LoginLog queryById(Long id) {
        return this.loginLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param loginLog 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<LoginLog> queryByPage(LoginLog loginLog, Integer pageNum, Integer pageSize) {
        Page<LoginLog> page = new Page<>(pageNum, pageSize);
        Page<LoginLog> pageResult = loginLogDao.queryByPage(page, loginLog);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog insert(LoginLog loginLog) {
        this.loginLogDao.insert(loginLog);
        return loginLog;
    }

    /**
     * 修改数据
     *
     * @param loginLog 实例对象
     * @return 实例对象
     */
    @Override
    public LoginLog update(LoginLog loginLog) {
        this.loginLogDao.update(loginLog);
        return this.queryById(loginLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.loginLogDao.deleteById(id) > 0;
    }
}
