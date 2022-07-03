package com.soapman;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MybatisPlusGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3307/mysql", "root", "123456")
            .schema("mysql");

    @Test
    public void generatorTable() {

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("soapman") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir() // 执行完毕不打开文件夹
                            .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.soapman") // 设置父包名
                            .controller("controller") // 生成controller层
                            .entity("entity") // 生成实体层
                            .service("service") // 生成service层
                            .mapper("mapper"); // 生成mapper层
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
                            .serviceBuilder() //开启service策略配置
                            .formatServiceFileName("%sService") //取消Service前的I
                            .controllerBuilder() //开启controller策略配置
                            .enableRestStyle() //配置restful风格
                            .enableHyphenStyle() //url中驼峰转连字符
                            .entityBuilder() //开启实体类配置
                            .enableLombok() //开启lombok
                            .enableChainModel(); //开启lombok链式操作
                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
