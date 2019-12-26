package com.yujianfei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yujianfei")
@EnableAspectJAutoProxy
public class DIConfig {

}
