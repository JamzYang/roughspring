package com.yang.roughspring.factory;

import com.yang.roughspring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String name);
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
