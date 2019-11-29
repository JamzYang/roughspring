package com.yang.roughspring;

import com.yang.roughspring.factory.AbstractBeanFactory;
import com.yang.roughspring.factory.AutowireCapableBeanFactory;
import com.yang.roughspring.factory.BeanFactory;
import com.yang.roughspring.io.Resource;
import com.yang.roughspring.io.ResourceLoader;
import com.yang.roughspring.xml.XmlBeanDefinitionReader;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author yang
 * Date 2019/11/25 1:12
 */
public class TestXMLBeanFactory {

    @Test
    public void testAutowire() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
//        Resource resource = resourceLoader.getResource("tinyico.xml");
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(resourceLoader);
        reader.loadBeanDefinitions("tinyioc.xml");
        AutowireCapableBeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = reader.getRegistry();
//        registry.forEach((bd)->beanFactory.registerBeanDefinition());
        for (String key: registry.keySet()) {
            beanFactory.registerBeanDefinition(key,registry.get(key));
        }
        Coder coder = (Coder)beanFactory.getBean("coder");
        Assert.assertEquals("yang",coder.getName());
        Assert.assertEquals("Hello, Roughspring",coder.getBook().getName());
    }

    @Test
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
