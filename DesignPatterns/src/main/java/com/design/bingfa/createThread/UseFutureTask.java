package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.FutureTask;

/**
 * 这个和之前实现Callable接口的方式差不多，只不过用匿名形式创建Callable
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:56
 */
@Slf4j
public class UseFutureTask {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                log.info("this is 7...");
                return "xiehongyu";
            });
            new Thread(futureTask).start();
        }
    }
}
