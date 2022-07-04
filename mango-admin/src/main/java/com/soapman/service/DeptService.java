package com.soapman.service;

import com.soapman.entity.Dept;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 机构管理(Dept)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
public interface DeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dept queryById(Long id);

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @return 查询结果
     */
    Page<Dept> queryByPage(Dept dept, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insert(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
