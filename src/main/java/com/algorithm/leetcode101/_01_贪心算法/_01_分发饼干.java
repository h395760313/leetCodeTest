package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/assign-cookies/
 * @Author: xiehongyu
 * @Date: 2022/05/09 15:13
 */
public class _01_分发饼干 {
    /**
     * @param g 饥饿度
     * @param s 饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie< s.length) {
            if (g[child] <= s[cookie]) child++;
            cookie++;
        }
        return child;
    }

    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{1,2,4,5}, new int[]{1,2,3,4}));
    }
}
