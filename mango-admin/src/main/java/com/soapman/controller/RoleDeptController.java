package com.soapman.controller;

import com.soapman.entity.RoleDept;
import com.soapman.service.RoleDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 角色机构(RoleDept)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Api(tags = "角色机构")
@RestController
@RequestMapping("roleDept")
public class RoleDeptController {
    /**
     * 服务对象
     */
    @Resource
    private RoleDeptService roleDeptService;

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<RoleDept>> queryByPage(RoleDept roleDept, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.roleDeptService.queryByPage(roleDept, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<RoleDept> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.roleDeptService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param roleDept 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<RoleDept> add(@RequestBody RoleDept roleDept) {
        return ResponseEntity.ok(this.roleDeptService.insert(roleDept));
    }

    /**
     * 编辑数据
     *
     * @param roleDept 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<RoleDept> edit(@RequestBody RoleDept roleDept) {
        return ResponseEntity.ok(this.roleDeptService.update(roleDept));
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
        return ResponseEntity.ok(this.roleDeptService.deleteById(id));
    }

}

