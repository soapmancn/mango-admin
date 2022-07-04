package com.soapman.dao;

import com.soapman.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * 机构管理(Dept)表数据库访问层
 *
 * @author soapman
 * @since 2022-07-04 14:59:30
 */
public interface DeptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dept queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param page 分页对象
     * @param dept 查询条件
     * @return 分页对象
     */
    Page<Dept> queryByPage(Page<Dept> page, Dept dept);

    /**
     * 统计总行数
     *
     * @param dept 查询条件
     * @return 总行数
     */
    long count(Dept dept);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int insert(Dept dept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Dept> entities);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

