package com.yang.roughspring;

import org.junit.Assert;
import org.junit.Test;

public class TestBeanDefinition {

    @Test
    public void testGetBean(){
        Book book = new Book("Hello, RoughSpring","100.00");
        BeanDefinition beanDefinition = new BeanDefinition(book);
        Book bean = (Book)beanDefinition.getBean();
        Assert.assertNotNull(bean);
    }
}
