package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色管理(Role)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = -68669966181066677L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
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

