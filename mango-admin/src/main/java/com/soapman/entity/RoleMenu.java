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
 * 角色菜单(RoleMenu)实体类
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "RoleMenu实体类")
@TableName("sys_role_menu")
public class RoleMenu extends Model<RoleMenu> implements Serializable {
    private static final long serialVersionUID = 170600584547260772L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;
    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private Long menuId;
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

