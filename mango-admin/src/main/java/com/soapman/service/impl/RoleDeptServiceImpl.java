package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.RoleDept;
import com.soapman.mapper.RoleDeptMapper;
import com.soapman.service.RoleDeptService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 角色机构(RoleDept)表服务实现类
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptMapper, RoleDept> implements RoleDeptService {

    /**
     * 分页查询
     *
     * @param roleDept
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<RoleDept> queryByPage(RoleDept roleDept, Integer pageNum, Integer pageSize) {
        Page<RoleDept> page = new Page<>(pageNum, pageSize);
        QueryWrapper<RoleDept> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(roleDept)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(roleDept.getCreateBy()), "createBy", roleDept.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(roleDept.getLastUpdateBy()), "lastUpdateBy", roleDept.getLastUpdateBy());
        }
        Page<RoleDept> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
