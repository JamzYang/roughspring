package com.yang.roughspring.aop;

/**
 * @author yang
 * Date 2019/12/2 21:58
 */
public class HelloProxyImpl implements HelloProxy {
    @Override
    public void sayHello() {
        System.out.println("hello, proxy");
    }
}
