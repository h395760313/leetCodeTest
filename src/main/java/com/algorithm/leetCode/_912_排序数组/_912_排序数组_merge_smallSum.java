package com.algorithm.leetCode._912_排序数组;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.Merge;
import org.junit.Test;

/**
 * 求小和，每一位数左边比自己小的和的总和
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author xiehongyu
 * @date 2022/02/25 15:20
 */
public class _912_排序数组_merge_smallSum {

    public int smallSum(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int begin, int end) {
        if (begin == end ) return 0;
        int mid = begin + ((end - begin) >> 1);
        return process(nums, begin, mid)
                +
                process(nums, mid + 1, end)
                +
                merge(nums, begin, mid, end);

    }

    private int merge(int[] nums, int begin, int mid, int end) {
        int[] help = new int[end - begin + 1];
        int i = 0;
        int l = begin, r = mid + 1;
        int res = 0;
        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
//                res += (end - r + 1) * nums[l];  // 求小和
                help[i++] = nums[l++];
            } else {
                res += mid - l + 1;  // 求逆序对
                help[i++] = nums[r++];
            }
        }
        while (l <= mid) {
            help[i++] = nums[l++];
        }
        while (r <= end) {
            help[i++] = nums[r++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[begin++] = help[j];
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(smallSum(new int[]{5,4,3,2,1})));
    }
}
