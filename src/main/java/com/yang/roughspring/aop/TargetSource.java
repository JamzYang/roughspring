package com.yang.roughspring.aop;

/**
 * @author yang
 * Date 2019/12/2 21:11
 */

public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource() {
    }

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
