package com.leetCode._1991_找到数组的中间位置;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/find-the-middle-index-in-array/
 * @author xiehongyu
 * @date 2022/01/06 11:36
 */
public class _1991_220106 {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            for(int j = 0; j < i; j++) {
                left += nums[j];
            }
            int right = sum - nums[i] - left;
            if(right == left) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(findMiddleIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
