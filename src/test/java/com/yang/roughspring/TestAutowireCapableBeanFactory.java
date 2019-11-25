package com.yang.roughspring;

import com.yang.roughspring.factory.AutowireCapableBeanFactory;
import com.yang.roughspring.factory.BeanFactory;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author yang
 * Date 2019/11/25 1:12
 */
public class TestAutowireCapableBeanFactory {

    @Test
    public void testAutowire(){
        PropertyValue nameProperty = new PropertyValue("name", "yang");
        PropertyValue bookProperty = new PropertyValue("book", new Book("Hello, RoughSpring",100.00));
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(nameProperty);
        propertyValues.addPropertyValue(bookProperty);
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName("com.yang.roughspring.Coder");
        bd.setPropertyValues(propertyValues);
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        beanFactory.registerBeanDefinition("coder",bd);
        Coder coder = (Coder)beanFactory.getBean("coder");
        Assert.assertEquals("yang",coder.getName());
        Assert.assertEquals("Hello, RoughSpring",coder.getBook().getName());
    }
}
