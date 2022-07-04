package com.soapman.service;

import com.soapman.entity.Dict;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 字典表(Dict)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
public interface DictService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dict queryById(Long id);

    /**
     * 分页查询
     *
     * @param dict 筛选条件
     * @return 查询结果
     */
    Page<Dict> queryByPage(Dict dict, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict insert(Dict dict);

    /**
     * 修改数据
     *
     * @param dict 实例对象
     * @return 实例对象
     */
    Dict update(Dict dict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
