package com.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/9 16:39
 */
public class BubbleSort {

    public void bubbleSort(int[] nums){
        for (int i = nums.length - 1; i >= 0 ; --i) {
            for (int j = i-1; j >= 0; --j) {
                if (nums[i] < nums[j]) {
                    swap(nums, i ,j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j){
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
                nums[j] = (int)(Math.random() * maxNum) - (int)(Math.random() * maxNum);
            }
            int[] originNums = Arrays.copyOf(nums, nums.length);
            bubbleSort(nums);
            Validator.validSort(originNums, nums);
        }
    }
}
