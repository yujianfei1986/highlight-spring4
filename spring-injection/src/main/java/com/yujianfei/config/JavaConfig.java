package com.yujianfei.config;

import com.yujianfei.di.EventListenerBean;
import com.yujianfei.di.EventPublisherBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yujianfei.di.FunctionServiceConfig;
import com.yujianfei.di.UserFunctionServiceConfig;
import org.springframework.context.annotation.DependsOn;

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

	@Bean(initMethod = "initialize")
	@DependsOn("eventListenerBean")
	public EventPublisherBean eventPublisherBean() {
		return new EventPublisherBean();
	}

	@Bean(name = "eventListenerBean", initMethod = "initialize")
	public EventListenerBean eventListenerBean() {
		return new EventListenerBean();
	}
}
