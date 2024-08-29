package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 这种属于进阶方式，可以通过Executors创建线程池，也可以自定义线程池
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:44
 */
@Slf4j
public class UseExecutorService {


    @Test
    public void test() {
        ExecutorService poolA = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            poolA.execute(() -> {
                log.info("this is 4A..." + Thread.currentThread().getName());
            });
        }


        ExecutorService poolB = new ThreadPoolExecutor(2, 3, 10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            poolB.submit(() -> {
                log.info("this is 4B..." + Thread.currentThread().getName());
            });
        }
        poolB.shutdown();

    }
}
