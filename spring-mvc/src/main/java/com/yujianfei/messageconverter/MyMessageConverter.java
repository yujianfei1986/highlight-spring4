package com.yujianfei.messageconverter;

import com.yujianfei.entity.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8"))); //新建自定义的媒体类型"application/x-wisely"
    }

    // 表明MyMessageConverter只处理DemoObj类
    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    // 重写redInternal方法，处理请求数据。代码表明MyMessageConverter只处理由 "-" 隔开的数据，并转成DemoObj的对象
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] arr = temp.split("-");
        DemoObj demoObj = new DemoObj();
        demoObj.setId(Long.parseLong(arr[0]));
        demoObj.setName(arr[1]);
        return demoObj;
    }

    // 重新writeInternal，处理如何输出数据到response.
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "Hello: " + obj.getId() + "-" + obj.getName();
        outputMessage.getBody().write(out.getBytes());
    }

}
