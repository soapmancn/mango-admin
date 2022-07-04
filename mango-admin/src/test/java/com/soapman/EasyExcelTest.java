package com.soapman;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soapman.entity.User;
import com.soapman.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class EasyExcelTest {

    @Resource
    UserService userService;

    @Test
    public void exportExcel() {
        Page<User> page = userService.queryByPage(new User(), 1, 1000);
        String fileName = "demo.xlsx";
        EasyExcel.write(fileName, User.class).sheet("用户信息").doWrite(page.getRecords());
    }

}
