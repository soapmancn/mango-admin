package com.soapman.service;

import com.soapman.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户管理(User)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    Page<User> queryByPage(User user, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 导出Excel
     * @param response
     * @param user
     * @param pageNum
     * @param pageSize
     */
    void exportExcelUser(HttpServletResponse response, User user, Integer pageNum, Integer pageSize) throws IOException;
}
