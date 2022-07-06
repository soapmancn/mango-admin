package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.Log;
import com.soapman.mapper.LogMapper;
import com.soapman.service.LogService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 系统操作日志(Log)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:42
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    /**
     * 分页查询
     *
     * @param log
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Log> queryByPage(Log log, Integer pageNum, Integer pageSize) {
        Page<Log> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Log> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(log)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(log.getUserName()), "user_name", log.getUserName());
            wrapper.like(StringUtils.isNotBlank(log.getOperation()), "operation", log.getOperation());
            wrapper.like(StringUtils.isNotBlank(log.getMethod()), "method", log.getMethod());
            wrapper.like(StringUtils.isNotBlank(log.getParams()), "params", log.getParams());
            wrapper.like(StringUtils.isNotBlank(log.getIp()), "ip", log.getIp());
            wrapper.like(StringUtils.isNotBlank(log.getCreateBy()), "create_by", log.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(log.getLastUpdateBy()), "last_update_by", log.getLastUpdateBy());
        }
        Page<Log> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
