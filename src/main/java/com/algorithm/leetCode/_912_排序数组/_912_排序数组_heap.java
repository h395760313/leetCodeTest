package com.algorithm.leetCode._912_排序数组;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 * @author xiehongyu
 * @date 2022/02/25 15:20
 */
public class _912_排序数组_heap {

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        System.out.println(JSON.toJSONString(nums));
    }

    public void heapInsert(int[] nums, int index){
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] nums, int index, int heapSize){
        int left = index * 2 + 1;
        int largest = 0;
        while (left < heapSize) {
            // 有子树
            largest = left + 1 < heapSize && nums[left] > nums[left + 1] ? left : left + 1;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            }

        }
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
