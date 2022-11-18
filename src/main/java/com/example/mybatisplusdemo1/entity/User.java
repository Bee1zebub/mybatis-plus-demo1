package com.example.mybatisplusdemo1.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class User {
    /**
     *  BIGINT类型，type：设置主键自增策略
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     *  fill：设置添加或修改的填充方式，使用MetaObjectHandler接口实现类
     */
    @TableField(fill = FieldFill.UPDATE)
    private String name;
    private Integer age;
    private String email;

    /**
     * "@Version" MP的乐观锁修改的版本号
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
