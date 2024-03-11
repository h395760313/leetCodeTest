package com.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/9 16:39
 */
public class SelectionSort {

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                min = nums[min] > nums[j] ? j : min;
            }
            if (min != i) {
                swap(nums, i, min);
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
            selectionSort(nums);
            Validator.validSort(originNums, nums);
        }
    }
}
