package com.example.mybatisplusdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.example.mybatisplusdemo1.mapper"})
public class MybatisPlusDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemo1Application.class, args);
    }

}