package com.leetCode._15_三数之和;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author xiehongyu
 * @date 2022/1/22 10:03
 */
public class _15_三数之和_template {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            if (l >= 1 && nums[l] == nums[l - 1]) continue;
            int x = l + 1;
            int y = nums.length - 1;

            while (x < y) {
                int sum = nums[l] + nums[x] + nums[y];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[l], nums[x], nums[y]));
                    while (x < y && nums[x] == nums[x + 1]) x++;
                    while (x < y && nums[y] == nums[y - 1]) y--;
                    x++;y--;
                }else if (sum < 0) {
                    x++;
                }else {
                    y--;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSum(new int[]{0,0,0})));
        // -1,0,0,1
    }
}
