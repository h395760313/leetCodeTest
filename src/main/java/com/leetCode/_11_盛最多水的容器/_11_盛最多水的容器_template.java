package com.leetCode._11_盛最多水的容器;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _11_盛最多水的容器_template {

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max((r - l) * Math.min(height[l], height[r]), max);
            if (height[l] > height[r]) r--;
            else l++;
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(maxArea(new int[]{9,8,7,6,5,4,5,6,7,8,9})));
    }
}
