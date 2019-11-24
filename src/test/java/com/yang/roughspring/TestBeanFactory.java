package com.yang.roughspring;

import org.junit.Assert;
import org.junit.Test;

public class TestBeanFactory {

    @Test
    public void testGetBean(){
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new Book());
        beanFactory.registerBeanDefinition("book", beanDefinition);
        Object book = beanFactory.getBean("book");
        Assert.assertNotNull(book);
    }
}
