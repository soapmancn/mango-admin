package com.soapman.controller;

import com.soapman.entity.Log;
import com.soapman.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 系统操作日志(Log)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Api(tags = "系统操作日志")
@RestController
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Log>> queryByPage(Log log, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.logService.queryByPage(log, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Log> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.logService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param log 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Log> add(@RequestBody Log log) {
        return ResponseEntity.ok(this.logService.insert(log));
    }

    /**
     * 编辑数据
     *
     * @param log 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<Log> edit(@RequestBody Log log) {
        return ResponseEntity.ok(this.logService.update(log));
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
        return ResponseEntity.ok(this.logService.deleteById(id));
    }

}

