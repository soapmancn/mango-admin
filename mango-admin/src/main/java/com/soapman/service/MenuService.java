package com.soapman.service;

import com.soapman.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 菜单管理(Menu)表服务接口
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface MenuService extends IService<Menu> {

    /**
     * 分页查询
     *
     * @param menu
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Menu> queryByPage(Menu menu, Integer pageNum, Integer pageSize);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<Menu> findByUser(String userName);

}
