package com.algorithm.leetCode._912_排序数组;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author xiehongyu
 * @date 2022/02/25 15:20
 */
public class _912_排序数组_merge {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        process(nums, 0, nums.length - 1);
        return nums;
    }

    public void process(int[] nums, int begin, int end){
        if (begin == end) return;
        int mid = begin + ((end - begin) >> 1);
        process(nums, begin, mid);
        process(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    public void merge(int[] nums, int begin, int mid, int end){
        int[] help = new int[end - begin + 1];
        int i = 0;
        int l = begin, r = mid + 1;
        while (l <= mid && r <= end) {
            help[i++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            help[i++] = nums[l++];
        }
        while (r <= end) {
            help[i++] = nums[r++];
        }

        for (int j = 0; j < help.length; j++) {
            nums[begin++] = help[j];
        }
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(sortArray(new int[]{5,2,3,1})));
    }
}
