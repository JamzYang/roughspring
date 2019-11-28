package com.yang.roughspring;

/**
 * @author yang
 * Date 2019/11/28 23:13
 */
public class BeanReference {
    private String beanName;
    private Object object;

    public BeanReference() {
    }

    public BeanReference(String beanName, Object object) {
        this.beanName = beanName;
        this.object = object;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
