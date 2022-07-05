package com.soapman.service;

import com.soapman.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统操作日志(Log)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface LogService extends IService<Log> {

    /**
     * 分页查询
     *
     * @param log
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Log> queryByPage(Log log, Integer pageNum, Integer pageSize);

}
