package com.algorithm.leetCode._912_排序数组;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author xiehongyu
 * @date 2022/02/25 15:20
 */
public class _912_排序数组_quick {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    public void quickSort(int[] nums, int L, int R){
        if (L >= R) return;
        swap(nums, L + (int)Math.random() * (R - L + 1), R);
        System.out.println(JSON.toJSONString(nums));
        int[] p = partition(nums, L, R);
        System.out.println(JSON.toJSONString(nums));
        System.out.println(JSON.toJSONString(p));

        System.out.println();
        System.out.println();
        quickSort(nums, L, p[0] - 1);
        quickSort(nums, p[1] + 1, R);
    }

    public int[] partition(int[] nums, int L, int R) {
        if (L == R) return new int[]{L, R};
        int num = nums[R];
        int i = L, i1 = L, i2 = R;
        while (i < i2) {
            if (nums[i] < num) {
                swap(nums, i++, i1++);
            }else if (nums[i] > num) {
                swap(nums, i, --i2);
            }else {
                i++;
            }
        }
        if (i2 != R) {
            swap(nums, i2 , R);
        }

        return new int[]{i1, i2};
    }

    private void swap(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    @Test
    public void test() {
        System.out.println(JSON.toJSONString(sortArray(new int[]{3,6,2,5,9,4,8,5,5})));
    }
}
