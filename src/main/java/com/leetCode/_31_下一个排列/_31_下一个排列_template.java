package com.leetCode._31_下一个排列;

import com.alibaba.fastjson.JSON;
import com.structure._3_栈.Stack;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * @author xiehongyu
 * @date 2022/1/24 11:21
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 */
public class _31_下一个排列_template {

    public double nextPermutation(int[] nums) {
        // 后一位和前一位比较，如果大于前一位，交换位置即可
        int len = 4;
        int n = len & 2;
        System.out.println(n);
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                break;
            }
        }
        // 没有下一个较大的
        int res[] = new int[10];
        if((len & 2) == 0) {
            return ((double)res[(len >> 1) - 1] + (double)res[len >> 1]) / 2;
        }else{
            return (double)res[(len >> 1)];
        }
    }

    @Test
    public void test() {
        nextPermutation(new int[]{1,2,3});
    }
}
