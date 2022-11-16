package com.example.mybatisplusdemo1.testjava;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class TestArray {

    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1,2,3);
        log.info("list:{}",list);
    }
}
