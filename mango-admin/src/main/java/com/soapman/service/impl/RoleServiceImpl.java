package com.soapman.service.impl;

import com.soapman.entity.Role;
import com.soapman.dao.RoleDao;
import com.soapman.service.RoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 角色管理(Role)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Long id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, Integer pageNum, Integer pageSize) {
        Page<Role> page = new Page<>(pageNum, pageSize);
        Page<Role> pageResult = roleDao.queryByPage(page, role);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleDao.deleteById(id) > 0;
    }
}
