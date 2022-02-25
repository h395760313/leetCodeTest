package com.algorithm.leetCode._9_回文数;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _9_回文数_220222 {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int curr = x;
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == curr;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isPalindrome(123321)));
    }
}
