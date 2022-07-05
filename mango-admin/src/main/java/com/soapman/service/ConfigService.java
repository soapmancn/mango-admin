package com.soapman.service;

import com.soapman.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统配置表(Config)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface ConfigService extends IService<Config> {

    /**
     * 分页查询
     *
     * @param config
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Config> queryByPage(Config config, Integer pageNum, Integer pageSize);

}
