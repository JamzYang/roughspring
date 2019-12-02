package com.yang.roughspring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author yang
 * Date 2019/12/2 21:31
 */
public class AdvisedSupport {
    private TargetSource targetSource;
    private MethodInterceptor methodInterceptor;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
