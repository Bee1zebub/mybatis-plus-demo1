package com.example.mybatisplusdemo1.testmp;

import com.example.mybatisplusdemo1.entity.User;
import com.example.mybatisplusdemo1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
public class TestSelect {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据id查询记录
     */
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        log.info("use:{}",user);
    }

    /**
     * 通过多个id批量查询 <==> SELECT id,name,age,email,create_time,update_time FROM user WHERE id IN ( ? , ? , ? )
     * Batch: 一批
     */
    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }

    /**
     * 简单的条件查询--通过map封装查询条件 <==> SELECT id,name,age,email,create_time,update_time FROM user WHERE name = ? AND id = ? AND age = ?
     * 注意：map中的key对应的是数据库中的列名。例如数据库user_id，实体类是userId，这时map的key需要填写user_id
     */
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",4);
        map.put("name", "Sandy");
        map.put("age", 21);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

}
