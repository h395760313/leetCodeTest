package com.leetcode.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * @Author: xiehongyu
 * @Date: 2024/2/22 20:46
 */
public class _11_盛最多水的容器 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        while (l < r) {
            int high = Math.min(height[l], height[r]);
            int len = (r - l);
            area = Math.max(len * high, area);
            while (l < r && height[l] <= high) {
                l++;
            }
            while (l < r && height[r] <= high) {
                r--;
            }
        }
        return area;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(maxArea(new int[]{2, 3, 10, 5, 7, 8, 9})));
    }
}
