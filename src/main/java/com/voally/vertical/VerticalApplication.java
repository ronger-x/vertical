package com.voally.vertical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@MapperScan("com.voally.vertical.mapper")
public class VerticalApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerticalApplication.class, args);
    }
}
