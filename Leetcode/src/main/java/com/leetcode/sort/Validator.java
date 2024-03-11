package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2024/3/9 16:49
 */
public class Validator {


    private static void sort(int[] nums) {
        Arrays.sort(nums);
    }

    public static void validSort(int[] originNums, int[] nums) {
        sort(originNums);
        for (int i = 0; i < nums.length; i++) {
            if (originNums[i] != nums[i]) {
                System.out.println("this sort is fucking error！！！");
                return;
            }
        }
    }

}
