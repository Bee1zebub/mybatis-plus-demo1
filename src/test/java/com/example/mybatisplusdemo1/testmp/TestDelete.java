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
import java.util.Map;

@SpringBootTest
@Slf4j
public class TestDelete {

    @Autowired
    UserMapper userMapper;

    /**
     * 物理删除：按照id删除 DELETE FROM user WHERE id=?
     */
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1592862041153794049L);
    }

    /**
     * 物理删除，批量删除 DELETE FROM user WHERE id IN ( ? , ? , ? )
     */
    @Test
    public void testDeleteBatchIds(){
        userMapper.deleteBatchIds(Arrays.asList(2,3,4));
    }

    /**
     * 简单的条件查询--通过map封装查询条件 <==> DELETE FROM user WHERE name = ? AND id = ?
     * 注意：map中的key对应的是数据库中的列名。例如数据库user_id，实体类是userId，这时map的key需要填写user_id
     */

    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",5);
        map.put("name","Billie");
        userMapper.deleteByMap(map);
    }


    //逻辑删除，新增一个标志位字段

    /**
     * 测试后发现，数据并没有被删除，deleted字段的值由0变成了1
     * 测试后分析打印的sql语句，是一条update
     * 注意：被删除数据的deleted 字段的值必须是 0，才能被选取出来执行逻辑删除的操作
     */
    @Test
    public void testLogicDeleteSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
