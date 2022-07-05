package com.soapman.service;

import com.soapman.entity.RoleDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 角色机构(RoleDept)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
public interface RoleDeptService extends IService<RoleDept> {

    /**
     * 分页查询
     *
     * @param roleDept
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<RoleDept> queryByPage(RoleDept roleDept, Integer pageNum, Integer pageSize);

}
