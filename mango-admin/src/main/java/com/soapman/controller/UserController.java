package com.soapman.controller;

import com.alibaba.excel.EasyExcel;
import com.soapman.entity.User;
import com.soapman.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户管理(User)表控制层
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
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
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageNum, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.update(user));
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
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    /**
     * 导出Excel
     * @param response
     * @param user
     * @param pageNum
     * @param pageSize
     * @throws IOException
     */
    @ApiOperation("导出Excel")
    @GetMapping("exportExcelUser")
    public void exportExcelUser(HttpServletResponse response, User user, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) throws IOException {
        userService.exportExcelUser(response, user, pageNum, pageSize);
    }

}

