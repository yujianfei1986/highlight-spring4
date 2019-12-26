package com.yujianfei.di;

public class UserFunctionServiceConfig {
	
	private FunctionServiceConfig functionServiceConfig;

	public void setFunctionServiceConfig(FunctionServiceConfig functionServiceConfig) {
		this.functionServiceConfig = functionServiceConfig;
	}
	
	public String sayHello(String word) {
		return functionServiceConfig.sayHello(word);
	}
}
