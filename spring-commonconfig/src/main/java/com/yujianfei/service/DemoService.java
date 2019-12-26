package com.yujianfei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2019/11/22.
 * Demo
 */
@Service
public class DemoService {
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    public void printResult() {
        System.out.println("Book name is " + bookName);
        System.out.println("Book author is " + environment.getProperty("book.author"));
    }
}
