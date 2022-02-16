package com.algorithm.leetCode._231_2的幂;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * @author xiehongyu
 * @date 2022/02/16 15:56
 */
public class _231_2的幂 {

    public boolean isPowerOfTwo(int n) {
        return powerOfTwo(1L, n);
    }

    private boolean powerOfTwo(long i, int n) {
        if (i > n) return false;
        if (i == n) return true;
        return powerOfTwo(i * 2, n);
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isPowerOfTwo(1073741825)));
    }
}
