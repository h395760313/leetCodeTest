package com.leetCode._33_搜索旋转排序数组;

import org.junit.Test;

import java.util.Arrays;


public class _33_搜索旋转排序数组_template {

    public int search(int[] nums, int target) {
        int rs = 0;
        for(int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                rs = i;
            }
        }

        int begin = 0, end = nums.length;
        if (target >= nums[0]) {
            end = rs;
        }else {
            begin = rs;
        }

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                begin = mid + 1;
            }else {
                end = mid;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(search(new int[]{1,2,3,4,5,6}, 3));
    }
}
