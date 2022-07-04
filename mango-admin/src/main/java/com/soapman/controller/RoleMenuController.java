package com.soapman.controller;

import com.soapman.entity.RoleMenu;
import com.soapman.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 角色菜单(RoleMenu)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
@Api(tags = "角色菜单")
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<RoleMenu>> queryByPage(RoleMenu roleMenu, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.roleMenuService.queryByPage(roleMenu, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<RoleMenu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.roleMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<RoleMenu> add(@RequestBody RoleMenu roleMenu) {
        return ResponseEntity.ok(this.roleMenuService.insert(roleMenu));
    }

    /**
     * 编辑数据
     *
     * @param roleMenu 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<RoleMenu> edit(@RequestBody RoleMenu roleMenu) {
        return ResponseEntity.ok(this.roleMenuService.update(roleMenu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.roleMenuService.deleteById(id));
    }

}

