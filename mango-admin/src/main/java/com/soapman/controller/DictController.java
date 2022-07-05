package com.soapman.controller;

import com.soapman.entity.Dict;
import com.soapman.service.DictService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 字典表(Dict)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
@Api(tags = "字典表")
@RestController
@RequestMapping("dict")
public class DictController {
    /**
     * 服务对象
     */
    @Resource
    private DictService dictService;

    /**
     * 分页查询
     *
     * @param dict 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public HttpResult queryByPage(Dict dict, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(dictService.queryByPage(dict, pageNum, pageSize));
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
        return HttpResult.ok(dictService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dict 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody Dict dict) {
        return HttpResult.ok(dictService.save(dict));
    }

    /**
     * 编辑数据
     *
     * @param dict 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody Dict dict) {
        return HttpResult.ok(dictService.updateById(dict));
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
        return HttpResult.ok(dictService.removeById(id));
    }

}

