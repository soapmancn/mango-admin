package com.soapman.mapper;

import com.soapman.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 菜单管理(Menu)表数据库访问层
 *
 * @author soapman
 * @since 2022-07-05 18:06:53
 */
public interface MenuMapper extends BaseMapper<Menu> {


    @Select("select m.* from sys_menu m, sys_user u, sys_user_role ur, sys_role_menu rm where u.name = #{userName} and u.id = ur.user_id and ur.role_id = rm.role_id and rm.menu_id = m.id")
    List<Menu> findByUserName(String userName);
}

