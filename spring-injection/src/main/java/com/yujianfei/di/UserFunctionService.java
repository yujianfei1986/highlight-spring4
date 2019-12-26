package com.yujianfei.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionService {
	
	@Autowired
	private FunctionService funtionService;
	
	public String sayHello(String word) {
		return funtionService.sayHello(word);
	}
	
}
