package com.yang.roughspring.context;

import com.yang.roughspring.BeanDefinition;
import com.yang.roughspring.factory.AbstractBeanFactory;
import com.yang.roughspring.factory.AutowireCapableBeanFactory;
import com.yang.roughspring.io.ResourceLoader;
import com.yang.roughspring.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author yang
 * Date 2019/11/30 23:20
 */
public class ClasspathApplicationContext extends AbstractApplicationContext {
    private String configLocation;

    public ClasspathApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    public ClasspathApplicationContext(String configLocation) throws Exception {
        this(new AutowireCapableBeanFactory(), configLocation);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {

    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
        reader.loadBeanDefinitions(configLocation);
        Map<String, BeanDefinition> registry = reader.getRegistry();
        for (String name : registry.keySet()) {
            beanFactory.registerBeanDefinition(name,registry.get(name));
        }
    }
}
