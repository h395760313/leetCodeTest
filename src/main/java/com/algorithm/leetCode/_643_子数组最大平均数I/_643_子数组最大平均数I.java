package com.algorithm.leetCode._643_子数组最大平均数I;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 */
public class _643_子数组最大平均数I {

    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;

        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, (double) nums[i]);
            }
            return res;
        }
        int start = 0, end = start + k - 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
            res = (double) sum / (double) k;
        }
        start++;
        end++;
        while (end < nums.length){
            int pre = nums[start - 1];
            int post = nums[end];
            sum = sum - pre + post;
            res = Math.max((double) sum / (double) k, res);
            start++;
            end++;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(findMaxAverage(new int[]{4,2,1,3,3}, 2));
    }
}
