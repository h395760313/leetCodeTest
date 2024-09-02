package com.leetcode.leetcode.leetCode2023._9_回文数;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @author xiehongyu
 * @date 2022/2/22 16:16
 */
public class _9_回文数_template {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int curr = x;
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return curr == res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isPalindrome(12321)));
    }
}
