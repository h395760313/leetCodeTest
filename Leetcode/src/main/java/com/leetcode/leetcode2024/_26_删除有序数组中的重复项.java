package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author xiehongyu
 * @date 2024/2/23 19:45
 */
public class _26_删除有序数组中的重复项 {


    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i++] = nums[j];
        }
        return i;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 2})));
    }
}
