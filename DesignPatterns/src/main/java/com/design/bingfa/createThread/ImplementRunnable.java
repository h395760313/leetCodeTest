package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 这也是一种常见的方式，实现Runnable接口并重写run方法
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:33
 */
@Slf4j
public class ImplementRunnable implements Runnable {


    @Override
    public void run() {
        log.info("this is 2...");
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(this).start();
        }
    }
}
