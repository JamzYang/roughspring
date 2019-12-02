package com.yang.roughspring.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yang
 * Date 2019/12/2 21:33
 */
public class JdkDynamicAopProxy implements  AopProxy, InvocationHandler {
    private AdvisedSupport advise;

    public JdkDynamicAopProxy(AdvisedSupport advise) {
        this.advise = advise;
    }

    @Override
    public Object getAopProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{advise.getTargetSource().getTargetClass()},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advise.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advise.getTargetSource().getTarget(),method,args));
    }
}
