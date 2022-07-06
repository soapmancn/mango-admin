package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Config;
import com.soapman.mapper.ConfigMapper;
import com.soapman.service.ConfigService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 系统配置表(Config)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:42
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    /**
     * 分页查询
     *
     * @param config
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Config> queryByPage(Config config, Integer pageNum, Integer pageSize) {
        Page<Config> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Config> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(config)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(config.getValue()), "value", config.getValue());
            wrapper.like(StringUtils.isNotBlank(config.getLabel()), "label", config.getLabel());
            wrapper.like(StringUtils.isNotBlank(config.getType()), "type", config.getType());
            wrapper.like(StringUtils.isNotBlank(config.getDescription()), "description", config.getDescription());
            wrapper.like(StringUtils.isNotBlank(config.getCreateBy()), "create_by", config.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(config.getLastUpdateBy()), "last_update_by", config.getLastUpdateBy());
            wrapper.like(StringUtils.isNotBlank(config.getRemarks()), "remarks", config.getRemarks());
        }
        Page<Config> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
