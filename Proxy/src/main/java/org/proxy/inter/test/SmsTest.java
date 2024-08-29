package org.proxy.inter.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.proxy.inter.SmsService;
import org.proxy.inter.impl.SmsServiceImpl;
import org.proxy.inter.proxy.SmsStaticProxy;
import org.proxy.inter.proxy.cglib.CglibProxyFactory;
import org.proxy.inter.proxy.cglib.MySmsService;
import org.proxy.inter.proxy.jdk.JdkProxyFactory;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 18:49
 */
@Slf4j
@RequiredArgsConstructor
public class SmsTest {

    @Test
    public void testStaticProxy() {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsStaticProxy smsStaticProxy = new SmsStaticProxy(smsService);
        smsStaticProxy.send("xiehongyu");
    }

    @Test
    public void testJdkProxy() {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxy.send("xiehongyu");
    }


    @Test
    public void testCglibProxy() {
        MySmsService mySmsService = (MySmsService) CglibProxyFactory.getProxy(MySmsService.class);
        mySmsService.send("xiehongyu");
    }


}
