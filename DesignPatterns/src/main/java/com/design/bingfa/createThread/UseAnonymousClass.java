package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 这种方式属于硬扯，就是直接new前面所说的Runnable接口，或者通过Lambda表达式书写
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 13:00
 */
@Slf4j
public class UseAnonymousClass {


    @Test
    public void test() {
        new Thread(new Runnable() { //使用匿名内部类
            @Override
            public void run() {
                log.info("this is 8A...");
            }
        }).start();

        new Thread(() -> { // 简写
            log.info("this is 8B");
        }).start();
    }
}
