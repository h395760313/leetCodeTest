package com.algorithm.leetCode._455_分发饼干;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies/
 * @author xiehongyu
 * @date 2022/2/9 17:39
 */
public class _455_分发饼干_template {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }



    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8})));
    }
}
