package com.algorithm.leetCode._7_整数反转;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _7_211124 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res > 214748364 || (res == 214748364 && tmp > 7) ||
                res < -214748364 || (res == -214748364 && tmp > 8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(reverse(1234567891)));
    }
}
