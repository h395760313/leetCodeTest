package org.proxy.inter.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 19:11
 */
@Slf4j
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("before method is {}", method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        log.info("after method is {}", method.getName());
        return result;
    }
}
