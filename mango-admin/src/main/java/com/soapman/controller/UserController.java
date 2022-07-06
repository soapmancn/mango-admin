package com.soapman.controller;

import com.soapman.entity.User;
import com.soapman.service.UserService;
import io.swagger.annotations.Api;
import com.soapman.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * 用户管理(User)表控制层
 *
 * @author soapman
 * @since 2022-07-05 18:06:54
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @PreAuthorize("hasAuthority('sys:user:view')")
    @ApiOperation("分页查询")
    @GetMapping
    public HttpResult queryByPage(User user, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return HttpResult.ok(userService.queryByPage(user, pageNum, pageSize));
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
        return HttpResult.ok(userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增是否成功
     */
    @ApiOperation("新增数据")
    @PostMapping
    public HttpResult add(@RequestBody User user) {
        return HttpResult.ok(userService.save(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑是否成功
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public HttpResult edit(@RequestBody User user) {
        return HttpResult.ok(userService.updateById(user));
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
        return HttpResult.ok(userService.removeById(id));
    }

}

