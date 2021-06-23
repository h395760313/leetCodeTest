package com.algorithm.array.a_1_easy;

/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。



 说明：


 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。




 示例：


输入：
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出：[1,2,2,3,5,6]



 提示：


 -10^9 <= nums1[i], nums2[i] <= 10^9
 nums1.length == m + n
 nums2.length == n

 Related Topics 数组 双指针
 👍 674 👎 0*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Merge {

    public static void main(String[] args) throws ParseException {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        merge2(nums1, m, nums2, n);

    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length - m; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);

        for (int i : nums1) {
            System.out.print("\t" + i);
        }
    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);

        for (int i : nums1) {
            System.out.print("\t" + i);
        }
    }
}
