package com.yang.roughspring.context;

import com.yang.roughspring.factory.AbstractBeanFactory;

/**
 * @author yang
 * Date 2019/11/30 23:18
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }
}
