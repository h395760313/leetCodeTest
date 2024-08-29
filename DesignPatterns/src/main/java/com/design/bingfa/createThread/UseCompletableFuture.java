package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture是JDK1.8引入的新类，可以用来执行异步任务
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:49
 */
@Slf4j
public class UseCompletableFuture {


    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            CompletableFuture.supplyAsync(() -> {
                log.info("this is 5...");
                return "xiehoongyu";
            });
        }

    }
}
