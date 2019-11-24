package com.yang.roughspring;

import com.yang.roughspring.factory.AbstractBeanFactory;
import com.yang.roughspring.factory.AutowireCapableBeanFactory;
import com.yang.roughspring.factory.BeanFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestBeanFactory {


    @Test
    public void testDoCreateBean(){
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.yang.roughspring.Book");
        beanFactory.registerBeanDefinition("book",beanDefinition);
        Object book = beanFactory.getBean("book");
        Assert.assertNotNull(book);
    }
}
