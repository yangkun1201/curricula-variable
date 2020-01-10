package com.xxj.curriculavariable;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xxj.curriculavariable.mapper")
public class CurriculaVariableApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurriculaVariableApplication.class, args);
    }

}
