package com.soapman.service.impl;

import com.soapman.entity.Menu;
import com.soapman.dao.MenuDao;
import com.soapman.service.MenuService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;

/**
 * 菜单管理(Menu)表服务实现类
 *
 * @author soapman
 * @since 2022-07-04 14:59:32
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(Long id) {
        return this.menuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Menu> queryByPage(Menu menu, Integer pageNum, Integer pageSize) {
        Page<Menu> page = new Page<>(pageNum, pageSize);
        Page<Menu> pageResult = menuDao.queryByPage(page, menu);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insert(Menu menu) {
        this.menuDao.insert(menu);
        return menu;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuDao.update(menu);
        return this.queryById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.menuDao.deleteById(id) > 0;
    }
}
