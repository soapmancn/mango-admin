package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 机构管理(Dept)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    private static final long serialVersionUID = 575447690271676211L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 机构名称
     */
    @ApiModelProperty("机构名称")
    private String name;
    /**
     * 上级机构ID，一级机构为0
     */
    @ApiModelProperty("上级机构ID，一级机构为0")
    private Long parentId;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;
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
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty("是否删除  -1：已删除  0：正常")
    private Integer delFlag;

}

