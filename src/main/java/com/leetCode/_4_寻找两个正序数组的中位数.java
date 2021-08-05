package com.leetCode;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] newArr = new int[len];
        /*while (p < nums1.length || q < nums2.length) {
            if (p < nums1.length && (q >= nums2.length || nums1[p] < nums2[q])) {
                newArr[index] = nums1[p];
                p++;
            }else {
                newArr[index] = nums2[q];
                q++;
            }
            index++;
        }*/
        System.arraycopy(nums1,0,newArr,0, nums1.length);
        System.arraycopy(nums2,0,newArr,nums1.length, nums2.length);
        Arrays.sort(newArr);
        System.out.println(JSON.toJSONString(newArr));
        return len % 2 == 0 ? (double) (newArr[len / 2] + newArr[len / 2 - 1]) /2 : newArr[len / 2];
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMedianSortedArrays(new int[]{1,3},new int[]{2})));
    }
}
