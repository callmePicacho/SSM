package org.lyy.test;

import org.junit.Test;
import org.lyy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

    @Test
    public void run(){
        // 获取context上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 得到 service 对象
        UserService service = (UserService)context.getBean("userService");
        // 调用测试
        service.queryAll();
    }
}
