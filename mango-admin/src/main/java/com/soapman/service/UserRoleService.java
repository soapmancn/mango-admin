package com.soapman.service;

import com.soapman.entity.UserRole;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户角色(UserRole)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:34
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    Page<UserRole> queryByPage(UserRole userRole, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
