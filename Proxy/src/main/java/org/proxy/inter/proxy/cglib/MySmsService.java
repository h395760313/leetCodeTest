package org.proxy.inter.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/27 19:17
 */
@Slf4j
public class MySmsService {
    public void send(String message) {
        log.info("message is {}", message);
    }
}
