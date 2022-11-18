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
        log.info("user的集合：{}", users);
    }

    /**
     * 手动增加
     */
    @Test
    void testInsert() {
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
    void testInsertMP() {
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
    void testUpdateById() {
        User user = new User();
        user.setId(2L);
        user.setAge(200);
        user.setName("bbb");

        userMapper.updateById(user);
    }

    /**
     * MP的方式修改，自动填充  MetaObjectHandler实现类的 setFieldValByName() 方法
     * UPDATE user SET name=?, update_time=? WHERE id=?
     */
    @Test
    void testUpdateByIdMP() {
        User user = new User();
        user.setId(1593055631424782337L);
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁修改版本号
     * 1、先查询；2、修改值；3、执行更新（重点在于此时得到一个完整的User对象，包括其版本号等信息）
     * UPDATE user SET name=?, age=?, email=?, version=?, create_time=?, update_time=? WHERE id=? AND version=?
     */
    @Test
    public void testOptimisticLocker() {
        // 1、先查询，得到版本号等信息，才能通过MP增加版本号
        User user = userMapper.selectById(1593073247551901698L);
        // 2、修改该User对象的一些属性值，其他的值不变
        user.setName("陈明扬");
        user.setAge(18);
        // 3、执行修改
        userMapper.updateById(user);
    }
}
