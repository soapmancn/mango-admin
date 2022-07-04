package com.soapman.controller;

import com.soapman.entity.Dept;
import com.soapman.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 机构管理(Dept)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
@Api(tags = "机构管理")
@RestController
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Dept>> queryByPage(Dept dept, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.deptService.queryByPage(dept, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Dept> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.deptService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dept 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Dept> add(@RequestBody Dept dept) {
        return ResponseEntity.ok(this.deptService.insert(dept));
    }

    /**
     * 编辑数据
     *
     * @param dept 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<Dept> edit(@RequestBody Dept dept) {
        return ResponseEntity.ok(this.deptService.update(dept));
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
        return ResponseEntity.ok(this.deptService.deleteById(id));
    }

}

