package com.yang.roughspring;

import com.sun.java.swing.plaf.nimbus.AbstractRegionPainter;
import com.yang.roughspring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * Date 2019/11/27 23:03
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }


    public Map<String, BeanDefinition> getRegistry(){
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
