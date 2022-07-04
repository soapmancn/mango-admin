package com.soapman.service;

import com.soapman.entity.Role;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色管理(Role)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Long id);

    /**
     * 分页查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    Page<Role> queryByPage(Role role, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
