package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/
 * @author xiehongyu
 * @date 2024/2/20 22:27
 */
public class _18_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        int i = 0;
        while (i < len - 3) {
            while (i <len - 3 && i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= len -3 ) {
                break;
            }
            int j = i + 1;
            while (j < len - 2) {
                while (j < len - 2 && j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j >= len - 2) {
                    break;
                }
                int k = j + 1;
                int l = len - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    }else if (sum > target) {
                        l--;
                    }else {
                        if (((nums[i] ^ sum) & (nums[j] ^ sum) & (nums[k] ^ sum) & (nums[l] ^ sum)) >= 0) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                        k++;
                        l--;
                    }
                    while (k < l && k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    while (k < l && l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                    }
                }
                j++;
            }
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296)));
    }
}
