package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/next-permutation
 * @Author: xiehongyu
 * @Date: 2024/03/06 22:46
 */
public class _31_下一个排列 {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        int j = nums.length - 1;

        while (nums[i] >= nums[i+1]) {
            i--;
            if (i < 0) {
                Arrays.sort(nums);
                return;
            }
        }

        while (nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);
        i++;
        j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        nextPermutation(new int[]{1,0,1,3,5,6,6,5,1,1,1}); // 1,2,1,1,5

    }
}
