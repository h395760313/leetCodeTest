package com.algorithm.leetCode._912_排序数组;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author xiehongyu
 * @date 2022/02/25 15:20
 */
public class _912_排序数组_quick_220225 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int L, int R) {
        if (L < R) {
            swap(nums, L + (int)Math.random() * (R - L + 1), R);
            int[] p = partition(nums, L, R);
            quickSort(nums, L, p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }

    /**
     * 这是一个处理nums[l..r]的函数
     * 默认以nums[r]做划分  nums[r] -> p    < p    ==p    > p
     *
     *
     * @param nums
     * @param L
     * @param R
     * @return 返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res  res[0]  res[1]
     */
    private int[] partition(int[] nums, int L, int R) {
        if (L == R) return new int[]{L, R};
        int num = nums[R];
        int less = L;
        int more = R;
        while (L < more) {
            if (nums[L] < num) {
                swap(nums, less++, L++);
            }else if (nums[L] > num) {
                swap(nums, L, --more);
            }else {
                L++;
            }
        }
        swap(nums, more, R);
        return new int[]{less, more};
    }

    private void swap(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(sortArray(new int[]{3,6,2,5,9,4,8,5,5})));
        //                                                       3,2,4,5,5,5,8,9,6
        //                                                       2,3,4,5,5,5,6,8,9

    }
}
