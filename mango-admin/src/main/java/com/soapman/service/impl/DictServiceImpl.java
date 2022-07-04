package com.soapman.service.impl;

import com.soapman.entity.Dict;
import com.soapman.dao.DictDao;
import com.soapman.service.DictService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 字典表(Dict)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Service("dictService")
public class DictServiceImpl implements DictService {
    @Resource
    private DictDao dictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dict queryById(Long id) {
        return this.dictDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dict 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Dict> queryByPage(Dict dict, Integer pageNum, Integer pageSize) {
        Page<Dict> page = new Page<>(pageNum, pageSize);
        Page<Dict> pageResult = dictDao.queryByPage(page, dict);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict insert(Dict dict) {
        this.dictDao.insert(dict);
        return dict;
    }

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict update(Dict dict) {
        this.dictDao.update(dict);
        return this.queryById(dict.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictDao.deleteById(id) > 0;
    }
}
