package com.soapman.service.impl;

import com.soapman.entity.UserRole;
import com.soapman.dao.UserRoleDao;
import com.soapman.service.UserRoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 用户角色(UserRole)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:34
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Long id) {
        return this.userRoleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, Integer pageNum, Integer pageSize) {
        Page<UserRole> page = new Page<>(pageNum, pageSize);
        Page<UserRole> pageResult = userRoleDao.queryByPage(page, userRole);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userRoleDao.deleteById(id) > 0;
    }
}
