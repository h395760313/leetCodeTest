package org.proxy.inter.proxy.jdk;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 18:55
 */
@Slf4j
@RequiredArgsConstructor
public class MyInvocationHandler implements InvocationHandler {


    public final Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("before method is {}", method.getName());
        Object invoke = method.invoke(target, args);
        log.info("after method is {}", method.getName());
        return invoke;
    }
}
