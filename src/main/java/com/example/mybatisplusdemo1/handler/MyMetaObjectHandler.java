package com.example.mybatisplusdemo1.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 使用MP实现添加操作，这个方法会执行，需要数据库没有设置默认值
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // MP自动添加创建时间
        // this.setFieldValByName("createTime", new Date(), metaObject);
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)

        // MP自动添加版本号值
        this.strictInsertFill(metaObject, "version",Integer.class,1);

        // MP自动添加逻辑删除标志位
        this.strictInsertFill(metaObject,"deleted",Integer.class,0);
        // 或者
        // this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }

    /**
     * 使用MP实现修改操作，这个方法会执行
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        //this.setFieldValByName("updateTime", new Date(), metaObject);
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
        this.strictUpdateFill(metaObject, "name", String.class, "cmy"); // 起始版本 3.3.0(推荐)
        // 或者
        // this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class); // 起始版本 3.3.3(推荐)
    }
}
