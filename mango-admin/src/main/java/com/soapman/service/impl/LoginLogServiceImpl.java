package com.soapman.service.impl;

import java.util.Objects;

import com.soapman.entity.LoginLog;
import com.soapman.mapper.LoginLogMapper;
import com.soapman.service.LoginLogService;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 系统登录日志(LoginLog)表服务实现类
 *
 * @author soapman
 * @since 2022-07-06 07:35:42
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    /**
     * 分页查询
     *
     * @param loginLog
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<LoginLog> queryByPage(LoginLog loginLog, Integer pageNum, Integer pageSize) {
        Page<LoginLog> page = new Page<>(pageNum, pageSize);
        QueryWrapper<LoginLog> wrapper = new QueryWrapper<>();
        if (!Objects.isNull(loginLog)) {
            //自定义过滤条件
            wrapper.like(StringUtils.isNotBlank(loginLog.getUserName()), "user_name", loginLog.getUserName());
            wrapper.like(StringUtils.isNotBlank(loginLog.getStatus()), "status", loginLog.getStatus());
            wrapper.like(StringUtils.isNotBlank(loginLog.getIp()), "ip", loginLog.getIp());
            wrapper.like(StringUtils.isNotBlank(loginLog.getCreateBy()), "create_by", loginLog.getCreateBy());
            wrapper.like(StringUtils.isNotBlank(loginLog.getLastUpdateBy()), "last_update_by", loginLog.getLastUpdateBy());
        }
        Page<LoginLog> result = baseMapper.selectPage(page, wrapper);
        return result;
    }

}
