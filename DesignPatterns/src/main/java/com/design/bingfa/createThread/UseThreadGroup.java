package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Java线程可以分组，可以创建多条线程作为一个组
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:53
 */
@Slf4j
public class UseThreadGroup {

    @Test
    public void test() {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        new Thread(threadGroup, () -> {
            log.info("this is 6A");
        }, "T1").start();
        new Thread(threadGroup, () -> {
            log.info("this is 6B");
        }, "T2").start();
        new Thread(threadGroup, () -> {
            log.info("this is 6C");
        }, "T3").start();
        new Thread(threadGroup, () -> {
            log.info("this is 6D");
        }, "T4").start();
    }
}
