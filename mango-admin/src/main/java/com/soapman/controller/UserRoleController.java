package com.soapman.controller;

import com.soapman.entity.UserRole;
import com.soapman.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 用户角色(UserRole)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
@Api(tags = "用户角色")
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<UserRole>> queryByPage(UserRole userRole, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.userRoleService.queryByPage(userRole, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<UserRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userRole 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<UserRole> add(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(this.userRoleService.insert(userRole));
    }

    /**
     * 编辑数据
     *
     * @param userRole 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<UserRole> edit(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(this.userRoleService.update(userRole));
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
        return ResponseEntity.ok(this.userRoleService.deleteById(id));
    }

}

