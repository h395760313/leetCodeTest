package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/non-decreasing-array/
 * @Author: xiehongyu
 * @Date: 2022/05/09 21:57
 */
public class _09_非递减数列 {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        boolean flag = true;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) return false;
                if (i + 2 < len && nums[i] > nums[i + 2]) {
                    nums[i] = nums[i+1];
                }else {
                    nums[i + 1] = nums[i];
                }
                flag = true;
                i = -1;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }
}
