package com.leetCode;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] newArr = new int[len];
        int p = 0;
        int q = 0;
        int index = 0;
        while (p < nums1.length || q < nums2.length) {
            if (p < nums1.length && (q >= nums2.length || nums1[p] < nums2[q])) {
                newArr[index] = nums1[p];
                p++;
            }else {
                newArr[index] = nums2[q];
                q++;
            }
            index++;
        }
        if (len % 2 == 0) {
            System.out.println((double) 5/2);
            return (double) (newArr[len / 2] + newArr[len / 2 - 1]) /2;
        }else {
            return newArr[len / 2];
        }
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{2},new int[]{})));
    }
}
