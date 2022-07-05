package com.soapman.service;

import com.soapman.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色管理(Role)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询
     *
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Role> queryByPage(Role role, Integer pageNum, Integer pageSize);

}
