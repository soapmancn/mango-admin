package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.RoleMenu;
import com.soapman.mapper.RoleMenuMapper;
import com.soapman.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 角色菜单(RoleMenu)表服务实现类
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    /**
     * 分页查询
     *
     * @param roleMenu
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<RoleMenu> queryByPage(RoleMenu roleMenu, Integer pageNum, Integer pageSize) {
        Page<RoleMenu> page = new Page<>(pageNum, pageSize);
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(roleMenu)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(roleMenu.getCreateBy()), "createBy", roleMenu.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(roleMenu.getLastUpdateBy()), "lastUpdateBy", roleMenu.getLastUpdateBy());
        }
        Page<RoleMenu> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
