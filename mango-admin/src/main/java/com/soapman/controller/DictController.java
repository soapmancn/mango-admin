package com.soapman.controller;

import com.soapman.entity.Dict;
import com.soapman.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 字典表(Dict)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
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
    public ResponseEntity<Page<Dict>> queryByPage(Dict dict, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.dictService.queryByPage(dict, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Dict> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.dictService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dict 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Dict> add(@RequestBody Dict dict) {
        return ResponseEntity.ok(this.dictService.insert(dict));
    }

    /**
     * 编辑数据
     *
     * @param dict 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<Dict> edit(@RequestBody Dict dict) {
        return ResponseEntity.ok(this.dictService.update(dict));
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
        return ResponseEntity.ok(this.dictService.deleteById(id));
    }

}

