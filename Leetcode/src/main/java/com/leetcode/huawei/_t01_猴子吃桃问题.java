package com.leetcode.huawei;

import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/01 16:50
 */
@Slf4j
public class _t01_猴子吃桃问题 {


    @Test
    public void test() {
        int n = 10;
        int count = 1;
        for (int i = 1; i < n; i++) {
            count = (count + 1) * 2;
        }
        System.out.println(count);
    }
}
