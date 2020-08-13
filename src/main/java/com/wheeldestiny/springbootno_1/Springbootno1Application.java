package com.wheeldestiny.springbootno_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@MapperScan("com.wheeldestiny.springbootno_1.dao")
public class Springbootno1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootno1Application.class, args);
    }
}
