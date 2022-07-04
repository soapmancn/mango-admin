package com.soapman.service.impl;

import com.soapman.entity.Log;
import com.soapman.dao.LogDao;
import com.soapman.service.LogService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 系统操作日志(Log)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(Long id) {
        return this.logDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Log> queryByPage(Log log, Integer pageNum, Integer pageSize) {
        Page<Log> page = new Page<>(pageNum, pageSize);
        Page<Log> pageResult = logDao.queryByPage(page, log);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log insert(Log log) {
        this.logDao.insert(log);
        return log;
    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.logDao.deleteById(id) > 0;
    }
}
