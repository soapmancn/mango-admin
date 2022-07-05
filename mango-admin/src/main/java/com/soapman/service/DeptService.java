package com.soapman.service;

import com.soapman.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 机构管理(Dept)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface DeptService extends IService<Dept> {

    /**
     * 分页查询
     *
     * @param dept
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Dept> queryByPage(Dept dept, Integer pageNum, Integer pageSize);

}
