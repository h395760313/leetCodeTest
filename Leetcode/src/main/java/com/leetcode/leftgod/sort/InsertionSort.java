package com.leetcode.leftgod.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/9 16:39
 */
public class InsertionSort {

    public void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; --j) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    @Test
    public void test() {
        int maxTime = 10000;
        for (int i = 0; i < maxTime; i++) {
            int maxCount = (int) (Math.random() * 1000);
            int maxNum = 100;
            int[] nums = new int[maxCount];
            for (int j = 0; j < maxCount; j++) {
                nums[j] = (int) (Math.random() * maxNum) - (int) (Math.random() * maxNum);
            }
            int[] originNums = Arrays.copyOf(nums, nums.length);
            insertionSort(nums);
            Validator.validSort(originNums, nums);
        }
    }
}
