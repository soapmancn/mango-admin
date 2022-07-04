package com.soapman.service.impl;

import com.soapman.entity.RoleMenu;
import com.soapman.dao.RoleMenuDao;
import com.soapman.service.RoleMenuService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 角色菜单(RoleMenu)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuDao roleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleMenu queryById(Long id) {
        return this.roleMenuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<RoleMenu> queryByPage(RoleMenu roleMenu, Integer pageNum, Integer pageSize) {
        Page<RoleMenu> page = new Page<>(pageNum, pageSize);
        Page<RoleMenu> pageResult = roleMenuDao.queryByPage(page, roleMenu);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu insert(RoleMenu roleMenu) {
        this.roleMenuDao.insert(roleMenu);
        return roleMenu;
    }

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu update(RoleMenu roleMenu) {
        this.roleMenuDao.update(roleMenu);
        return this.queryById(roleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleMenuDao.deleteById(id) > 0;
    }
}
