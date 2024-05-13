package com.example.shardingspherejdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan({"com.example.shardingspherejdbc.dao"})
public class ShardingSphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcApplication.class, args);
    }

}
