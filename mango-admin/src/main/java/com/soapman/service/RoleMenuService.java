package com.soapman.service;

import com.soapman.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色菜单(RoleMenu)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 分页查询
     *
     * @param roleMenu
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<RoleMenu> queryByPage(RoleMenu roleMenu, Integer pageNum, Integer pageSize);

}
