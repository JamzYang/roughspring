package com.yang.roughspring.factory;

import com.yang.roughspring.BeanDefinition;

/**
 * @author yang
 * Date 2019/11/25 0:02
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
