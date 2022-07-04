package com.soapman.controller;

import com.soapman.entity.Menu;
import com.soapman.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;

/**
 * 菜单管理(Menu)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:31
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Menu>> queryByPage(Menu menu, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.menuService.queryByPage(menu, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<Menu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.menuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param menu 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Menu> add(@RequestBody Menu menu) {
        return ResponseEntity.ok(this.menuService.insert(menu));
    }

    /**
     * 编辑数据
     *
     * @param menu 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<Menu> edit(@RequestBody Menu menu) {
        return ResponseEntity.ok(this.menuService.update(menu));
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
        return ResponseEntity.ok(this.menuService.deleteById(id));
    }

}
