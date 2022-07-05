package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Menu;
import com.soapman.mapper.MenuMapper;
import com.soapman.service.MenuService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 菜单管理(Menu)表服务实现类
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    /**
     * 分页查询
     *
     * @param menu
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Menu> queryByPage(Menu menu, Integer pageNum, Integer pageSize) {
        Page<Menu> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(menu)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(menu.getName()), "name", menu.getName());
            wrapper.like(StringUtils.isNotBlank(menu.getUrl()), "url", menu.getUrl());
            wrapper.like(StringUtils.isNotBlank(menu.getPerms()), "perms", menu.getPerms());
            wrapper.like(StringUtils.isNotBlank(menu.getIcon()), "icon", menu.getIcon());
            wrapper.like(StringUtils.isNotBlank(menu.getCreateBy()), "createBy", menu.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(menu.getLastUpdateBy()), "lastUpdateBy", menu.getLastUpdateBy());
        }
        Page<Menu> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
