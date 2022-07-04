package com.soapman.controller;

import com.soapman.entity.Config;
import com.soapman.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 系统配置表(Config)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:29
 */
@Api(tags = "系统配置表")
@RestController
@RequestMapping("config")
public class ConfigController {
    /**
     * 服务对象
     */
    @Resource
    private ConfigService configService;

    /**
     * 分页查询
     *
     * @param config 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Config>> queryByPage(Config config, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.configService.queryByPage(config, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Config> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.configService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param config 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Config> add(@RequestBody Config config) {
        return ResponseEntity.ok(this.configService.insert(config));
    }

    /**
     * 编辑数据
     *
     * @param config 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<Config> edit(@RequestBody Config config) {
        return ResponseEntity.ok(this.configService.update(config));
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
        return ResponseEntity.ok(this.configService.deleteById(id));
    }

}

