package com.soapman.service;

import com.soapman.entity.RoleDept;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色机构(RoleDept)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
public interface RoleDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleDept queryById(Long id);

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @return 查询结果
     */
    Page<RoleDept> queryByPage(RoleDept roleDept, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    RoleDept insert(RoleDept roleDept);

    /**
     * 修改数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    RoleDept update(RoleDept roleDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
