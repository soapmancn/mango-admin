package com.soapman.service;

import com.soapman.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 字典表(Dict)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface DictService extends IService<Dict> {

    /**
     * 分页查询
     *
     * @param dict
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Dict> queryByPage(Dict dict, Integer pageNum, Integer pageSize);

}
