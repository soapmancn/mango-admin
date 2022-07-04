package com.soapman.service.impl;

import com.soapman.entity.Config;
import com.soapman.dao.ConfigDao;
import com.soapman.service.ConfigService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 系统配置表(Config)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private ConfigDao configDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(Long id) {
        return this.configDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Config> queryByPage(Config config, Integer pageNum, Integer pageSize) {
        Page<Config> page = new Page<>(pageNum, pageSize);
        Page<Config> pageResult = configDao.queryByPage(page, config);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configDao.insert(config);
        return config;
    }

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configDao.update(config);
        return this.queryById(config.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.configDao.deleteById(id) > 0;
    }
}
