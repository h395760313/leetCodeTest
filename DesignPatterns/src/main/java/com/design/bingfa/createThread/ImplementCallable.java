package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 和上一种方式类似，只不过这种方式可以拿到线程执行完的返回值
 *
 * @Author: xiehongyu
 * @Date: 2024/04/09 12:33
 */
@Slf4j
public class ImplementCallable implements Callable {


    @Override
    public Object call() {
        log.info("this is 2...");
        return "xiehongyu";
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            ImplementCallable implementCallable = new ImplementCallable();
            FutureTask futureTask = new FutureTask(implementCallable);
            new Thread(futureTask).start();
            log.info((String) futureTask.get());
        }
    }
}
