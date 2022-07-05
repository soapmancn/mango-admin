package com.soapman.controller;

import com.soapman.entity.Dept;
import com.soapman.service.DeptService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 机构管理(Dept)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
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
    public HttpResult queryByPage(Dept dept, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(deptService.queryByPage(dept, pageNum, pageSize));
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
        return HttpResult.ok(deptService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dept 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody Dept dept) {
        return HttpResult.ok(deptService.save(dept));
    }

    /**
     * 编辑数据
     *
     * @param dept 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody Dept dept) {
        return HttpResult.ok(deptService.updateById(dept));
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
        return HttpResult.ok(deptService.removeById(id));
    }

}

