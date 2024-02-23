package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 * @author xiehongyu
 * @date 2024/2/23 19:45
 */
public class _26_删除有序数组中的重复项 {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            nums[++index] = nums[i];
        }
        return ++index;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(removeDuplicates(new int[]{1,1,1,2,2,2,2})));
    }
}
