package org.proxy.inter.impl;

import lombok.extern.slf4j.Slf4j;
import org.proxy.inter.SmsService;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 18:47
 */
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Override
    public void send(String message) {
        log.info("message is {}", message);
    }
}
