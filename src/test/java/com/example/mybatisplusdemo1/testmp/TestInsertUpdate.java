package com.example.mybatisplusdemo1.testmp;

import com.example.mybatisplusdemo1.entity.User;
import com.example.mybatisplusdemo1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class TestInsertUpdate {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部
     */
    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        log.info("user的集合：{}",users);
    }

    /**
     * 手动增加
     */
    @Test
    void testInsert(){
        User user = new User();
        user.setName("Lucy");
        user.setAge(23);
        user.setEmail("Lucy@qq.com");

        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }
    /**
     * MP的方式增加，自动填充  MetaObjectHandler实现类的 setFieldValByName() 方法
     */
    @Test
    void testInsertMP(){
        User user = new User();
        user.setName("Lucy");
        user.setAge(23);
        user.setEmail("Lucy@qq.com");

        userMapper.insert(user);
    }

    /**
     * 手动修改
     */
    @Test
    void testUpdateById(){
        User user = new User();
        user.setId(2L);
        user.setAge(200);
        user.setName("bbb");

        userMapper.updateById(user);
    }
    /**
     * MP的方式修改，自动填充  MetaObjectHandler实现类的 setFieldValByName() 方法
     */
    @Test
    void testUpdateByIdMP(){
        User user = new User();
        user.setId(1592863347763408898L);
        userMapper.updateById(user);
    }
}
