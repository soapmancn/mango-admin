package com.soapman.entity;

import java.util.Date;


import lombok.*;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 系统操作日志(Log)实体类
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Log实体类")
@TableName("sys_log")
public class Log extends Model<Log> implements Serializable {
    private static final long serialVersionUID = 750338460317568678L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    @TableId(type = IdType.AUTO)
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

