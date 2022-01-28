package com.leetCode._34_在排序数组中查找元素的第一个和最后一个位置;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


public class _34_在排序数组中查找元素的第一个和最后一个位置_template {

    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1, l = 0, r = nums.length - 1;
        while (l < nums.length) {
            if (nums[l] == target) {
                first = l;
                break;
            }
            l++;
        }
        if (l == nums.length - 1) return new int[]{first,last};

        while (r >= 0) {
            if (nums[r] == target) {
                last = r;
                break;
            }
            r--;
        }
        return new int[]{first,last};
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
}
