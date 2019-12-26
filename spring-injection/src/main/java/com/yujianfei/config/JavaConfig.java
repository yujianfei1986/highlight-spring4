package com.yujianfei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yujianfei.di.FunctionServiceConfig;
import com.yujianfei.di.UserFunctionServiceConfig;

@Configuration
public class JavaConfig {
	
	@Bean
	public FunctionServiceConfig functionServiceConfig() {
		return new FunctionServiceConfig();
	}
	
	@Bean
	public UserFunctionServiceConfig userFunctionServiceConfig() {
		UserFunctionServiceConfig userFunctionServiceConfig = new UserFunctionServiceConfig();
		userFunctionServiceConfig.setFunctionServiceConfig(functionServiceConfig());
		return userFunctionServiceConfig;
	}
}
