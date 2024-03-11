package com.leetcode.leftgod.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/11 10:48
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    private void process(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] p = partition(nums, l, r);
        process(nums, l, p[0] - 1);
        process(nums, p[1] + 1, r);
    }

    private int[] partition(int[] nums, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l)) + l;
        swap(nums, randomIndex, r);
        int i = l - 1;
        int j = r;
        while (l < j) {
            if (nums[l] < nums[r]) {
                swap(nums, ++i, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --j, l);
            } else {
                l++;
            }
        }
        swap(nums, r, j);
        return new int[]{i + 1, j};
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
            quickSort(nums);
            Validator.validSort(originNums, nums);
        }
    }
}
