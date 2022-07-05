package com.soapman.controller;

import com.soapman.entity.Config;
import com.soapman.service.ConfigService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 系统配置表(Config)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
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
    public HttpResult queryByPage(Config config, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(configService.queryByPage(config, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public HttpResult queryById(@PathVariable("id") Long id) {
        return HttpResult.ok(configService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param config 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody Config config) {
        return HttpResult.ok(configService.save(config));
    }

    /**
     * 编辑数据
     *
     * @param config 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody Config config) {
        return HttpResult.ok(configService.updateById(config));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping
    public HttpResult deleteById(Long id) {
        return HttpResult.ok(configService.removeById(id));
    }

}

