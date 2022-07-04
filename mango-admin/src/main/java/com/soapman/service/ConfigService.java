package com.soapman.service;

import com.soapman.entity.Config;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统配置表(Config)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
public interface ConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Long id);

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @return 查询结果
     */
    Page<Config> queryByPage(Config config, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config insert(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    Config update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
