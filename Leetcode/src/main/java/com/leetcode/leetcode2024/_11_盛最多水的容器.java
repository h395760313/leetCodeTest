package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * @Author: xiehongyu
 * @Date: 2024/2/22 20:46
 */
public class _11_盛最多水的容器 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(maxArea(new int[]{1,8,6,2,5,4,8,3,7})));
    }
}
