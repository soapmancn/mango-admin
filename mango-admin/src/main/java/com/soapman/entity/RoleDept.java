package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色机构(RoleDept)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDept implements Serializable {
    private static final long serialVersionUID = 956631936518629484L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;
    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    private Long deptId;
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

