package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统配置表(Config)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Config implements Serializable {
    private static final long serialVersionUID = 605483209206432956L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 数据值
     */
    @ApiModelProperty("数据值")
    private String value;
    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    private String label;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;
    /**
     * 排序（升序）
     */
    @ApiModelProperty("排序（升序）")
    private Double sort;
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
    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String remarks;
    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;

}

