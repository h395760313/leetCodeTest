package com.algorithm.leetCode._53_最大子数组和;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author xiehongyu
 * @date 2022/02/16 10:31
 */
public class _53_最大子数组和 {
    /**
     * 暴力  O(n^3)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        for (int begin = 0; begin < len; begin++) {
            for (int end = begin; end < len; end++) {
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        for (int begin = 0; begin < len; begin++) {
            int sum = 0;
            for (int end = begin; end < len; end++) {
                sum += nums[end];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray3(nums, 0, nums.length);
    }

    public int maxSubArray3(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];

        int mid = (begin + end) >> 1;
        int leftMax = 0;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = 0;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        int max = leftMax + rightMax;

        return Math.max(
                max,
                Math.max(maxSubArray3(nums, begin, mid), maxSubArray3(nums, mid, end))
        );
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(maxSubArray(new int[]{})));
    }
}
