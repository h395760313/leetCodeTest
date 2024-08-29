package org.proxy.inter.proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.proxy.inter.SmsService;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 18:48
 */
@Slf4j
@RequiredArgsConstructor
public class SmsStaticProxy implements SmsService {
    private final SmsService smsService;

    @Override
    public void send(String message) {
        log.info("before method send()");
        smsService.send(message);
        log.info("after method send()");
    }

}
