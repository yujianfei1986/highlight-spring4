package com.yujianfei.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Admin on 2019/11/22.
 * 待发布事件
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
