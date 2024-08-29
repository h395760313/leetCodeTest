package com.leetcode.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 * @Author: xiehongyu
 * @Date: 2024/06/24 18:51
 */
@Slf4j
public class TestHW2 {


    @Test
    public void test() {
        int n = 16;
        int hash = 3456789;
        System.out.println(hash % n);
        System.out.println((n - 1) & hash);


//        System.out.println(childArr2(new int[]{2, 4, 6}));
//        System.out.println(childArr2(new int[]{2, 4, 6, 8}));
//        System.out.println(childArr2(new int[]{2, 4, 6, 8, 10}));
//        System.out.println(childArr2(new int[]{2, 4, 6, 8, 10, 12}));
//        System.out.println(childArr2(new int[]{2, 4, 6, 8, 10, 12, 14}));
//        System.out.println(childArr2(new int[]{2, 4, 6, 8, 10, 12, 14, 16}));
        // i = 1   res = 1
        // i = 2   res = 3
        // i = 3   res = 6
        // i = 4   res = 10
        // i = 5   res = 15
        // i = 6   res = 21


        // i = 0   res = 1
        // i = 1   res = 3
        // i = 2   res = 3
        // i = 3   res = 4
        // i = 4   res = 6
        // i = 5   res = 9
    }


    private int childArr(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int i = 0;
        int count = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = j + 1;

            while (k < nums.length) {
                if (nums[k] - nums[k - 1] != nums[k - 1] - nums[k - 2]) {
                    break;
                }
                count++;
                k++;
            }
            i++;
        }
        return count;
    }

    private int childArr2(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int diff = nums[1] - nums[0];
        int i = 2;
        int res = 0;
        int count = 0;
        while (i < nums.length) {
            int newDiff = nums[i] - nums[i - 1];
            if (newDiff == diff) {
                count++;
            } else {
                res += count * (count + 1) / 2;
                diff = newDiff;
                count = 0;
            }
            i++;
        }
        res += count * (count + 1) / 2;
        return res;
    }
}
