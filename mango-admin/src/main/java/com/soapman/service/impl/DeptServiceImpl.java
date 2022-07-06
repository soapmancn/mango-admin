package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Dept;
import com.soapman.mapper.DeptMapper;
import com.soapman.service.DeptService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 机构管理(Dept)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:42
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    /**
     * 分页查询
     *
     * @param dept
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Dept> queryByPage(Dept dept, Integer pageNum, Integer pageSize) {
        Page<Dept> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(dept)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(dept.getName()), "name", dept.getName());
            wrapper.like(StringUtils.isNotBlank(dept.getCreateBy()), "create_by", dept.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(dept.getLastUpdateBy()), "last_update_by", dept.getLastUpdateBy());
        }
        Page<Dept> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
