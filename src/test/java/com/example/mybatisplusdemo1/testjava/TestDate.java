package com.example.mybatisplusdemo1.testjava;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
public class TestDate {
    @Test
     public void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        log.info("LocalDateTime->{}",now);
        Date date = new Date();
        log.info("Date->{}",date);
    }
}
