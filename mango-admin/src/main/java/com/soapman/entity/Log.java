package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统操作日志(Log)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log implements Serializable {
    private static final long serialVersionUID = 124748001940713316L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;
    /**
     * 用户操作
     */
    @ApiModelProperty("用户操作")
    private String operation;
    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String method;
    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String params;
    /**
     * 执行时长(毫秒)
     */
    @ApiModelProperty("执行时长(毫秒)")
    private Long time;
    /**
     * IP地址
     */
    @ApiModelProperty("IP地址")
    private String ip;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String lastUpdateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date lastUpdateTime;

}

