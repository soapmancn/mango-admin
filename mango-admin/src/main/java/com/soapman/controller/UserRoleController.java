package com.soapman.controller;

import com.soapman.entity.UserRole;
import com.soapman.service.UserRoleService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 用户角色(UserRole)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Api(tags = "用户角色")
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public HttpResult queryByPage(UserRole userRole, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(userRoleService.queryByPage(userRole, pageNum, pageSize));
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
        return HttpResult.ok(userRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userRole 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody UserRole userRole) {
        return HttpResult.ok(userRoleService.save(userRole));
    }

    /**
     * 编辑数据
     *
     * @param userRole 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody UserRole userRole) {
        return HttpResult.ok(userRoleService.updateById(userRole));
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
        return HttpResult.ok(userRoleService.removeById(id));
    }

}

