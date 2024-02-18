package com.algorithm.leetcode101._02_双指针;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * @Author: xiehongyu
 * @Date: 2022/05/10 11:36
 */
public class _01_两数之和II输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(twoSum(new int[]{5, 25, 75}, 100)));

    }
}
