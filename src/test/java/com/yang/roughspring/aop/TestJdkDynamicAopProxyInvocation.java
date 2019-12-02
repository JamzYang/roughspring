package com.yang.roughspring.aop;

import com.yang.roughspring.HelloWorldService;
import org.junit.Test;

/**
 * @author yang
 * Date 2019/12/2 21:47
 */
public class TestJdkDynamicAopProxyInvocation {

    @Test
    public void testInterceptor(){
        HelloWorldService service = new HelloWorldService();
        HelloProxy hello = new HelloProxyImpl();
        AdvisedSupport advise = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(HelloProxy.class, hello);
        advise.setTargetSource(targetSource);

        advise.setMethodInterceptor(new TimerInterceptor());

        JdkDynamicAopProxy aopProxy = new JdkDynamicAopProxy(advise);
        HelloProxy helloProxy = (HelloProxy)aopProxy.getAopProxy();
        helloProxy.sayHello();

    }
}
