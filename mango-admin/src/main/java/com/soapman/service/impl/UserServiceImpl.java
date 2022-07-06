package com.soapman.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.soapman.entity.Menu;
import com.soapman.entity.User;
import com.soapman.mapper.UserMapper;
import com.soapman.service.MenuService;
import com.soapman.service.UserService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * 用户管理(User)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private MenuService menuService;

    /**
     * 分页查询
     *
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<User> queryByPage(User user, Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(user)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(user.getName()), "name", user.getName());
            wrapper.like(StringUtils.isNotBlank(user.getNickName()), "nick_name", user.getNickName());
            wrapper.like(StringUtils.isNotBlank(user.getAvatar()), "avatar", user.getAvatar());
            wrapper.like(StringUtils.isNotBlank(user.getPassword()), "password", user.getPassword());
            wrapper.like(StringUtils.isNotBlank(user.getSalt()), "salt", user.getSalt());
            wrapper.like(StringUtils.isNotBlank(user.getEmail()), "email", user.getEmail());
            wrapper.like(StringUtils.isNotBlank(user.getMobile()), "mobile", user.getMobile());
            wrapper.like(StringUtils.isNotBlank(user.getCreateBy()), "create_by", user.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(user.getLastUpdateBy()), "last_update_by", user.getLastUpdateBy());
        }
        Page<User> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

    @Override
    public Set<String> findPermissions(String userName) {
        Set<String> perms = new HashSet<>();
        List<Menu> menus = menuService.findByUser(userName);
        for(Menu menu:menus) {
            if(menu.getPerms() != null && !"".equals(menu.getPerms())) {
                perms.add(menu.getPerms());
            }
        }
        return perms;
    }

}
