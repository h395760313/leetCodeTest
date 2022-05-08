package com.algorithm.leetCode._1_两数之和;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xiehongyu
 * @date 2022/1/5 10:03
 */
public class _1_220509 {
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
