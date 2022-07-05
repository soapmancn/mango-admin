package com.soapman.service;

import com.soapman.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户角色(UserRole)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 分页查询
     *
     * @param userRole
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<UserRole> queryByPage(UserRole userRole, Integer pageNum, Integer pageSize);

}
