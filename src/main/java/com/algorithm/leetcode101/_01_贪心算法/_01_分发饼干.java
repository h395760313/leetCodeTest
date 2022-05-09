package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/assign-cookies/
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩
 * 子可以吃饱。
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
        while(cookie < s.length && child < g.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
