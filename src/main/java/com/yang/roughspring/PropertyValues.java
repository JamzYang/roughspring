package com.yang.roughspring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yang
 * Date 2019/11/25 0:49
 */
public class PropertyValues {
    //避免重复添加属性
    private Set<PropertyValue> propertyValueSet = new HashSet<>();

    public Set<PropertyValue> getPropertyValueSet() {
        return propertyValueSet;
    }
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueSet.add(propertyValue);
    }
}
