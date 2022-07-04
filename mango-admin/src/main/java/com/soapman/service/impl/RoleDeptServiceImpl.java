package com.soapman.service.impl;

import com.soapman.entity.RoleDept;
import com.soapman.dao.RoleDeptDao;
import com.soapman.service.RoleDeptService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 角色机构(RoleDept)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
@Service("roleDeptService")
public class RoleDeptServiceImpl implements RoleDeptService {
    @Resource
    private RoleDeptDao roleDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleDept queryById(Long id) {
        return this.roleDeptDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<RoleDept> queryByPage(RoleDept roleDept, Integer pageNum, Integer pageSize) {
        Page<RoleDept> page = new Page<>(pageNum, pageSize);
        Page<RoleDept> pageResult = roleDeptDao.queryByPage(page, roleDept);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDept insert(RoleDept roleDept) {
        this.roleDeptDao.insert(roleDept);
        return roleDept;
    }

    /**
     * 修改数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDept update(RoleDept roleDept) {
        this.roleDeptDao.update(roleDept);
        return this.queryById(roleDept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleDeptDao.deleteById(id) > 0;
    }
}
