package com.huage.easycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.huage.easycode.mapper")
@EnableSwagger2
public class EasycodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycodeApplication.class, args);
    }

}
