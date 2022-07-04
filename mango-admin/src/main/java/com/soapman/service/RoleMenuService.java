package com.soapman.service;

import com.soapman.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色菜单(RoleMenu)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
public interface RoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleMenu queryById(Long id);

    /**
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @return 查询结果
     */
    Page<RoleMenu> queryByPage(RoleMenu roleMenu, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu insert(RoleMenu roleMenu);

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    RoleMenu update(RoleMenu roleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
