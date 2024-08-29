package com.design.bingfa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/09 13:19
 */
@Slf4j
public class DeadLock {

    private final static Object object1 = new Object();
    private final static Object object2 = new Object();

    @Test
    public void test() {

        new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread() + "get object1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "waiting get object2");
                synchronized (object2) {
                    System.out.println(Thread.currentThread() + "get object2");
                }
            }
        }, "T1").start();


        new Thread(() -> {
            synchronized (object2) {
                System.out.println(Thread.currentThread() + "get object2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread() + "waiting get object1");
                synchronized (object1) {
                    System.out.println(Thread.currentThread() + "get object1");
                }
            }
        }, "T2").start();

    }
}
