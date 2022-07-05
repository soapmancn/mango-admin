package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.User;
import com.soapman.mapper.UserMapper;
import com.soapman.service.UserService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 用户管理(User)表服务实现类
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

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
            wrapper.like(StringUtils.isNotBlank(user.getNickName()), "nickName", user.getNickName());
            wrapper.like(StringUtils.isNotBlank(user.getAvatar()), "avatar", user.getAvatar());
            wrapper.like(StringUtils.isNotBlank(user.getPassword()), "password", user.getPassword());
            wrapper.like(StringUtils.isNotBlank(user.getSalt()), "salt", user.getSalt());
            wrapper.like(StringUtils.isNotBlank(user.getEmail()), "email", user.getEmail());
            wrapper.like(StringUtils.isNotBlank(user.getMobile()), "mobile", user.getMobile());
            wrapper.like(StringUtils.isNotBlank(user.getCreateBy()), "createBy", user.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(user.getLastUpdateBy()), "lastUpdateBy", user.getLastUpdateBy());
        }
        Page<User> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
