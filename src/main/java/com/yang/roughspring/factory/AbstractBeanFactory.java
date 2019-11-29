package com.yang.roughspring.factory;

import com.yang.roughspring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yang
 * Date 2019/11/24 23:28
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
