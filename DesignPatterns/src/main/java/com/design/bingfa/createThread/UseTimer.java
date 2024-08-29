package com.design.bingfa.createThread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: xiehongyu
 * @Date: 2024/04/09 13:03
 */
@Slf4j
public class UseTimer {


    @Test
    public void test() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("this is 9...");
            }
        }, 0, 1000);
    }
}
