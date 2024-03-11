package com.leetcode.leftgod.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/9 16:39
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    private void process(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        process(nums, l, m);
        process(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        int[] help = new int[end - begin + 1];
        int i = 0;
        int l = begin;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            help[i++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            help[i++] = nums[l++];
        }
        while (r <= end){
            help[i++] = nums[r++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[begin++] = help[j];
        }
    }


    @Test
    public void test() {
        int maxTime = 10000;
        for (int i = 0; i < maxTime; i++) {
            int maxCount = (int) (Math.random() * 100);
            int maxNum = 100;
            int[] nums = new int[maxCount];
            for (int j = 0; j < maxCount; j++) {
                nums[j] = (int) (Math.random() * maxNum) - (int) (Math.random() * maxNum);
            }
            int[] originNums = Arrays.copyOf(nums, nums.length);
            mergeSort(nums);
            Validator.validSort(originNums, nums);
        }
    }
}
