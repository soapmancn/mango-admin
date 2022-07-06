package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Dict;
import com.soapman.mapper.DictMapper;
import com.soapman.service.DictService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 字典表(Dict)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:42
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    /**
     * 分页查询
     *
     * @param dict
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Dict> queryByPage(Dict dict, Integer pageNum, Integer pageSize) {
        Page<Dict> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(dict)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(dict.getValue()), "value", dict.getValue());
            wrapper.like(StringUtils.isNotBlank(dict.getLabel()), "label", dict.getLabel());
            wrapper.like(StringUtils.isNotBlank(dict.getType()), "type", dict.getType());
            wrapper.like(StringUtils.isNotBlank(dict.getDescription()), "description", dict.getDescription());
            wrapper.like(StringUtils.isNotBlank(dict.getCreateBy()), "create_by", dict.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(dict.getLastUpdateBy()), "last_update_by", dict.getLastUpdateBy());
            wrapper.like(StringUtils.isNotBlank(dict.getRemarks()), "remarks", dict.getRemarks());
        }
        Page<Dict> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
