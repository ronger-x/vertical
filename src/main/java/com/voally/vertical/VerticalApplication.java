package com.voally.vertical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.voally.vertical.mapper")
public class VerticalApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerticalApplication.class, args);
    }
}
