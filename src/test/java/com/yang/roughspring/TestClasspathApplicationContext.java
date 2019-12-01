package com.yang.roughspring;

import com.yang.roughspring.context.ClasspathApplicationContext;
import org.junit.Test;

/**
 * @author yang
 * Date 2019/12/1 0:21
 */
public class TestClasspathApplicationContext {

    @Test
    public void context() throws Exception {
        ClasspathApplicationContext context = new ClasspathApplicationContext("tinyioc.xml");
        HelloWorldService service = (HelloWorldService)context.getBean("helloWorldService");
        service.helloWorld();
    }
}
