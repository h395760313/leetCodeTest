package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoin是JDK1.7引入的新线程池，基于分治思想实现。而后续JDK1.8的parallelStream并行流，默认就基于ForkJoin实现
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 13:05
 */
@Slf4j
public class UseForkJoinPool {


    @Test
    public void test() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(() -> {
            log.info("this is 10A...");
        });

        List<String> list = Arrays.asList("this is 10B...");
        list.parallelStream().forEach(log::info);
    }
}
