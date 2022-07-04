package com.soapman.service.impl;

import com.soapman.entity.Dept;
import com.soapman.dao.DeptDao;
import com.soapman.service.DeptService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 机构管理(Dept)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Long id) {
        return this.deptDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Dept> queryByPage(Dept dept, Integer pageNum, Integer pageSize) {
        Page<Dept> page = new Page<>(pageNum, pageSize);
        Page<Dept> pageResult = deptDao.queryByPage(page, dept);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept insert(Dept dept) {
        this.deptDao.insert(dept);
        return dept;
    }

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public Dept update(Dept dept) {
        this.deptDao.update(dept);
        return this.queryById(dept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.deptDao.deleteById(id) > 0;
    }
}
