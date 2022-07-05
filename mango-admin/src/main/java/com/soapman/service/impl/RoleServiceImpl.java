package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Role;
import com.soapman.mapper.RoleMapper;
import com.soapman.service.RoleService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 角色管理(Role)表服务实现类
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    /**
     * 分页查询
     *
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Role> queryByPage(Role role, Integer pageNum, Integer pageSize) {
        Page<Role> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(role)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(role.getName()), "name", role.getName());
            wrapper.like(StringUtils.isNotBlank(role.getRemark()), "remark", role.getRemark());
            wrapper.like(StringUtils.isNotBlank(role.getCreateBy()), "createBy", role.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(role.getLastUpdateBy()), "lastUpdateBy", role.getLastUpdateBy());
        }
        Page<Role> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
