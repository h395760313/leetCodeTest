package com.algorithm.leetCode._41_缺失的第一个正数;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * @author xiehongyu
 * @date 2022/02/07 11:13
 */
public class _41_缺失的第一个正数 {
    public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
                if (!set.contains(set.size())) {
                    return set.size();
                }
            }
        }
        return set.size() + 1;
    }


    /**
     * 使用辅助数组，创建一个长度大于nums的数组arr
     * 先遍历数组nums，将每一个大于零且小于数组长度的数存入arr的对应位置上，如3存入arr[3]
     * 再遍历数组arr，遇到arr[i] != i则返回i，如果没遇到则表示前面数据都是连续的，返回数组arr的长度
     *
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:94.8 MB,击败了30.44% 的Java用户
     */
    public int firstMissingPositive2(int[] nums) {
        int[] arr = new int[nums.length + 1];

        for (int x : nums) {
            if (x > 0 && x < arr.length) {
                arr[x] = x;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != i) return i;
        }

        return arr.length;
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        for (int i = 0; i < len; ++i) {
            while (nums[i] > 0 && nums[i] != i + 1 && nums[i] < len + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;
    }


    //交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
