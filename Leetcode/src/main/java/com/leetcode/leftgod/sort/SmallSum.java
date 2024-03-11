package com.leetcode.leftgod.sort;

import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2024/3/11 09:40
 */
public class SmallSum {

    public int smallSum(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(nums, l, m)
                + process(nums, m + 1, r)
                + merge(nums, l, m, r);
    }

    private int merge(int[] nums, int begin, int mid, int right) {
        int[] help = new int[right - begin + 1];
        int i = 0;
        int l = begin;
        int r = mid + 1;
        int count = 0;
        while (l <= mid && r <= right) {
            help[i++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
            count++;
        }
        while (l <= mid) {
            help[i++] = nums[l++];
        }
        while (r <= right) {
            help[i++] = nums[r++];
        }
        for (int j : help) {
            nums[begin++] = j;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(smallSum(new int[]{1,3,4,2,5}));
    }
}
