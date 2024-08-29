package com.leetcode.huawei;

import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/24 12:05
 */
@Slf4j
public class _t03_判断是不是ipv4 {


    @Test
    public void test() {
        String address = "200.1.1.1";

        String[] split = address.split("\\.");
        if (split.length != 4) {
            System.out.println(false);
            return;
        }
        for (int i = 0; i < 4; i++) {
            try {
                int j = Integer.parseInt(split[i]);
                if (j < 0 || j > 255) {
                    System.out.println(false);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
