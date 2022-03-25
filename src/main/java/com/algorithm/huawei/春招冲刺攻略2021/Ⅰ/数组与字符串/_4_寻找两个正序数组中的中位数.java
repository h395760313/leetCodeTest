package com.algorithm.huawei.春招冲刺攻略2021.Ⅰ.数组与字符串;

import com.alibaba.fastjson.JSON;

/**
 * @author xiehongyu
 * @date 2022-03-17
 */
public class _4_寻找两个正序数组中的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] <= nums2[i2]) {
                arr[i++] = nums1[i1++];
            }else {
                arr[i++] = nums2[i2++];
            }
        }
        while (i1 < nums1.length) {
            arr[i++] = nums1[i1++];
        }
        while (i2 < nums2.length) {
            arr[i++] = nums2[i2++];
        }


        if ((len & 1) == 0) return arr[len / 2 - 1] + (arr[len / 2] - arr[len / 2 - 1]) / 2.0;
        return arr[len / 2];
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4})));
    }

}
