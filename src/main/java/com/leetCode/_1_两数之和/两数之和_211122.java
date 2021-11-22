package com.leetCode._1_两数之和;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class 两数之和_211122 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(twoSum(new int[]{1,2,3,5},7)));
    }
}
