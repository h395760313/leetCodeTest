package com.design.bingfa.executor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/09 19:28
 */
@Slf4j
public class ExecutorExample {


    @Test
    public void test() throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                log.info("this is " + Thread.currentThread().getName());
            });
            Thread.sleep(500);
        }
        executor.shutdown();


    }
}
