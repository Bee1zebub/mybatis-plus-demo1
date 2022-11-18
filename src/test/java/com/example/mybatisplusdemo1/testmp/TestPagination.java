package com.example.mybatisplusdemo1.testmp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo1.MybatisPlusDemo1Application;
import com.example.mybatisplusdemo1.entity.User;
import com.example.mybatisplusdemo1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class TestPagination {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testPagination() {
        // current – 当前页 size – 每页显示条数
        Page<User> page = new Page<>(2, 3);

        userMapper.selectPage(page, null);

        log.info("current:{}", page.getCurrent()); //当前页
        log.info("records:{}", page.getRecords()); // 每页数据的List集合
        log.info("size:{}", page.getSize());   //每页显示条数
        log.info("total:{}", page.getTotal()); //返回的总记录数
        log.info("pages:{}", page.getPages()); //页数

        log.info("hasNext:{}", page.hasNext()); //判断是否是否存在下一页
        log.info("hasPrevious:{}", page.hasPrevious());//判断是否是否存在上一页


    }
}
