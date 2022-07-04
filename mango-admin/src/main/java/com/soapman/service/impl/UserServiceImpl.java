package com.soapman.service.impl;

import com.alibaba.excel.EasyExcel;
import com.soapman.entity.User;
import com.soapman.dao.UserDao;
import com.soapman.service.UserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 用户管理(User)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:33
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, Integer pageNum, Integer pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        Page<User> pageResult = userDao.queryByPage(page, user);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 导出Excel
     * @param response
     * @param user
     * @param pageNum
     * @param pageSize
     * @throws IOException
     */
    @Override
    public void exportExcelUser(HttpServletResponse response, User user, Integer pageNum, Integer pageSize) throws IOException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        Page<User> page = queryByPage(user, pageNum, pageSize);
        EasyExcel.write(response.getOutputStream(), User.class).sheet("用户信息").doWrite(page.getRecords());
    }
}
