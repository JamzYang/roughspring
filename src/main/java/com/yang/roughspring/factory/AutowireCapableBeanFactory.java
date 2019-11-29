package com.yang.roughspring.factory;

import com.yang.roughspring.BeanDefinition;
import com.yang.roughspring.BeanReference;
import com.yang.roughspring.PropertyValue;
import com.yang.roughspring.PropertyValues;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * 可以自动装配属性
 * @author yang
 * Date 2019/11/25 0:02
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            beanDefinition.setBean(bean);
            applyPropertyValues(bean,beanDefinition);
            return bean;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        Set<PropertyValue> propertyValueSet = beanDefinition.getPropertyValues().getPropertyValueSet();
        for (PropertyValue propertyValue : propertyValueSet) {
            String name = propertyValue.getName();
            Field field = bean.getClass().getDeclaredField(name);
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference ref = (BeanReference) value;
                String beanName = ref.getBeanName();
                value = getBean(beanName);
            }
            field.set(bean,value);
        }
    }
}
