package com.design.bingfa.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/09 19:11
 */
@Slf4j
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMDD HHmm"));

    @Override
    public void run() {
        log.info("Thread Name = {} default Formater = {}", Thread.currentThread().getName(), formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        formatter.set(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss"));
        log.info("Thread Name = {} formatter = {}", Thread.currentThread().getName(), formatter.get().toPattern());
    }

    @Test
    public void test() throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }

}
