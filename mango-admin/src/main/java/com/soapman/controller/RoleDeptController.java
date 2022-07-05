package com.soapman.controller;

import com.soapman.entity.RoleDept;
import com.soapman.service.RoleDeptService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 角色机构(RoleDept)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
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
    public HttpResult queryByPage(RoleDept roleDept, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(roleDeptService.queryByPage(roleDept, pageNum, pageSize));
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
        return HttpResult.ok(roleDeptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param roleDept 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody RoleDept roleDept) {
        return HttpResult.ok(roleDeptService.save(roleDept));
    }

    /**
     * 编辑数据
     *
     * @param roleDept 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody RoleDept roleDept) {
        return HttpResult.ok(roleDeptService.updateById(roleDept));
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
        return HttpResult.ok(roleDeptService.removeById(id));
    }

}

