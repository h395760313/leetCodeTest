package com.algorithm.leetcode101._02_双指针;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 * @Author: xiehongyu
 * @Date: 2022/05/10 12:08
 */
public class _02_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int mi = m - 1;
        int ni = n - 1;
        int i = m + n - 1;
        while (mi >= 0 && ni >= 0) {
            nums1[i--] = nums1[mi] >= nums2[ni] ? nums1[mi--] : nums2[ni--];
        }
        while (i >= 0 && ni >= 0) {
            nums1[i--] =  nums2[ni--];
        }
        System.out.println(JSON.toJSONString(nums1));
    }

    @Test
    public void test() {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
