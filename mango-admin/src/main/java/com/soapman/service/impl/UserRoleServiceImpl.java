package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.UserRole;
import com.soapman.mapper.UserRoleMapper;
import com.soapman.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 用户角色(UserRole)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:43
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    /**
     * 分页查询
     *
     * @param userRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, Integer pageNum, Integer pageSize) {
        Page<UserRole> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(userRole)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(userRole.getCreateBy()), "create_by", userRole.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(userRole.getLastUpdateBy()), "last_update_by", userRole.getLastUpdateBy());
        }
        Page<UserRole> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
