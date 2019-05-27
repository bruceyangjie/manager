package com.bruce.manager.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bruce on 19/1/23 -- 11:24
 */
@Configuration
@MapperScan(basePackages = "com.bruce.manager.dao.*")
public class Mybatis {

}
