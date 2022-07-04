package com.soapman.service;

import com.soapman.entity.Menu;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 菜单管理(Menu)表服务接口
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
public interface MenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu queryById(Long id);

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @return 查询结果
     */
    Page<Menu> queryByPage(Menu menu, Integer pageNum, Integer pageSize);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    Menu update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
