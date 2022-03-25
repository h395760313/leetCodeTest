package com.algorithm.huawei.春招冲刺攻略2021.概述;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @author xiehongyu
 * @date 2022-03-16
 */
public class _1248_统计优美子数组 {

    public static int numberOfSubarrays1(int[] nums, int k) {
        int l = 0, r = k - 1, res = 0, count = 0, leftEvenCount = 0, rightEvenCount = 0;
        while (l < nums.length && r < nums.length && count != k) {
            count = 0;
            for (int i = l; i <= r; i++) {
                if ((nums[i] & 1) != 0) count++;
            }
            r++;
        }
        // 没有找到第一组优美子数组
        if (count != k) return 0;
        // 找到第一组优美子数组
        res++;
        while (l < nums.length && r < nums.length) {
            if ((nums[r] & 1) != 0) {
                // 新进来的数为奇数
                if ((nums[l] & 1) == 0) {
                    // 如果左边界的数为偶数，把窗口左侧缩到左边界为奇数
                    while ((nums[l] & 1) == 0) {
                        l++;
                        res++;
                    }
                }
                // 如果左边界的数为奇数，则直接窗口右移
                l++;
            }
            r++;
            res++;
        }

        while (l < r && (nums[l] & 1) == 0) {
            leftEvenCount++;
            l++;
        }
        while (l < r && (nums[r - 1] & 1) == 0) {
            rightEvenCount++;
            r--;
        }

        if (leftEvenCount == 0 && rightEvenCount == 0) return res;
        if (leftEvenCount != 0 && rightEvenCount != 0) return res + leftEvenCount * rightEvenCount;
        return res + leftEvenCount + rightEvenCount;
    }




    public static int numberOfSubarrays(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += (nums[j] & 1);
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{3,8,0,1,8,3,0,2,2,8,8,3,1,1}, 4));
    }

}
