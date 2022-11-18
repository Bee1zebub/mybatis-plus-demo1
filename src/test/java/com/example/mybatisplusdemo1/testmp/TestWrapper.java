package com.example.mybatisplusdemo1.testmp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo1.entity.User;
import com.example.mybatisplusdemo1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TestWrapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * MP实现复杂查询
     * SELECT id,name,age,email,version,create_time,update_time,deleted FROM user WHERE deleted=0 AND (age > ?)
     */
    @Test
    public void testSelectQuery(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age",18);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
