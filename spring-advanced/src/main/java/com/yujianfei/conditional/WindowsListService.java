package com.yujianfei.conditional;

/**
 * Created by Admin on 2019/12/6.
 * 实现ListService接口
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
