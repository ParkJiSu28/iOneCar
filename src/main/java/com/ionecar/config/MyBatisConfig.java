package com.ionecar.config;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = "com.ionecar.mapper")
public class MyBatisConfig {

}
