package com.soapman.service;

import com.soapman.entity.Log;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统操作日志(Log)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
public interface LogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(Long id);

    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @return 查询结果
     */
    Page<Log> queryByPage(Log log, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
