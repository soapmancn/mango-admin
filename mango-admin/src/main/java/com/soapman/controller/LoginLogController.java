package com.soapman.controller;

import com.soapman.entity.LoginLog;
import com.soapman.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 系统登录日志(LoginLog)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Api(tags = "系统登录日志")
@RestController
@RequestMapping("loginLog")
public class LoginLogController {
    /**
     * 服务对象
     */
    @Resource
    private LoginLogService loginLogService;

    /**
     * 分页查询
     *
     * @param loginLog 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<LoginLog>> queryByPage(LoginLog loginLog, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.loginLogService.queryByPage(loginLog, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<LoginLog> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.loginLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param loginLog 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<LoginLog> add(@RequestBody LoginLog loginLog) {
        return ResponseEntity.ok(this.loginLogService.insert(loginLog));
    }

    /**
     * 编辑数据
     *
     * @param loginLog 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<LoginLog> edit(@RequestBody LoginLog loginLog) {
        return ResponseEntity.ok(this.loginLogService.update(loginLog));
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
        return ResponseEntity.ok(this.loginLogService.deleteById(id));
    }

}

