package com.yujianfei.profile;

import com.yujianfei.config.CommonConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Admin on 2019/12/11.
 * spring测试功能
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {

    @Autowired
    private DemoBean demoBean;

    @Test
    public void prodBeanShouldInject(){
        String expected = "from production profile";
        String actual = demoBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
