package org.proxy.inter.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 18:57
 */
@Slf4j
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MyInvocationHandler(target));
    }
}
