package com.soapman.dao;

import com.soapman.entity.Config;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * 系统配置表(Config)表数据库访问层
 *
 * @author soapman
 * @since 2022-07-04 14:59:29
 */
public interface ConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param page   分页对象
     * @param config 查询条件
     * @return 分页对象
     */
    Page<Config> queryByPage(Page<Config> page, Config config);

    /**
     * 统计总行数
     *
     * @param config 查询条件
     * @return 总行数
     */
    long count(Config config);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int insert(Config config);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Config> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Config> entities);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

