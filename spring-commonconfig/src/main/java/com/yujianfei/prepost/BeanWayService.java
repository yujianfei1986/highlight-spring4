package com.yujianfei.prepost;

/**
 * Created by Admin on 2019/11/21.
 * spring方式创建bean并维护生命周期
 */
public class BeanWayService {

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destory-method");
    }

}
