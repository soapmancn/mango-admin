package com.soapman.controller;

import com.soapman.entity.RoleMenu;
import com.soapman.service.RoleMenuService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 角色菜单(RoleMenu)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Api(tags = "角色菜单")
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public HttpResult queryByPage(RoleMenu roleMenu, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(roleMenuService.queryByPage(roleMenu, pageNum, pageSize));
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
        return HttpResult.ok(roleMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody RoleMenu roleMenu) {
        return HttpResult.ok(roleMenuService.save(roleMenu));
    }

    /**
     * 编辑数据
     *
     * @param roleMenu 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody RoleMenu roleMenu) {
        return HttpResult.ok(roleMenuService.updateById(roleMenu));
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
        return HttpResult.ok(roleMenuService.removeById(id));
    }

}

