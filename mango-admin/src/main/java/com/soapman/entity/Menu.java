package com.soapman.entity;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单管理(Menu)实体类
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {
    private static final long serialVersionUID = 843590281347100140L;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;
    /**
     * 父菜单ID，一级菜单为0
     */
    @ApiModelProperty("父菜单ID，一级菜单为0")
    private Long parentId;
    /**
     * 菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)
     */
    @ApiModelProperty("菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)")
    private String url;
    /**
     * 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
     */
    @ApiModelProperty("授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)")
    private String perms;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @ApiModelProperty("类型   0：目录   1：菜单   2：按钮")
    private Integer type;
    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;
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

