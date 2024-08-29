package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 这是最普通的方式，继承Thread类，重写run方法
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:33
 */
@Slf4j
public class ExtendThread extends Thread {


    @Override
    public void run() {
        log.info("this is 1...");
    }

    @Test
    public void test() {
//        for (int i = 0; i < 10; i++) {
//            this.start();
//        }
        for (int i = 0; i < 10; i++) {
            new ExtendThread().start();
        }
    }
}
