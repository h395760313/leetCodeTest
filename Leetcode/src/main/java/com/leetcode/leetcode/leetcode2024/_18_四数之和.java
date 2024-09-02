package com.leetcode.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/
 *
 * @author xiehongyu
 * @date 2024/2/20 22:27
 */
public class _18_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int q = 0;
        while (q < nums.length - 3) {
            if (q < nums.length - 3 && q > 0 && nums[q] == nums[q - 1]) {
                q++;
                continue;
            }
            if ((long)nums[q] + nums[q + 1] + nums[q + 2] + nums[q + 3] > target) {
                break;
            }
            if ((long)nums[q] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                q++;
                continue;
            }
            int w = q + 1;

            while (w < nums.length - 2) {
                if (w > q + 1 && w < nums.length - 2 && nums[w] == nums[w - 1]) {
                    w++;
                    continue;
                }
                if ((long)nums[q] + nums[w] + nums[w + 1] + nums[w + 2] > target) {
                    break;
                }
                if ((long)nums[q] + nums[w] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    w++;
                    continue;
                }
                int e = w + 1;
                int r = nums.length - 1;
                while (e < r) {
                    long sum = nums[q] + nums[w] + nums[e] + nums[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        e++;
                    } else {
                        if (sum == target) {
                            res.add(Arrays.asList(nums[q], nums[w], nums[e], nums[r]));
                        }
                        while (e < r && nums[e] == nums[e + 1]) {
                            e++;
                        }
                        while (e < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        e++;
                        r--;
                    }
                }
                w++;
            }
            q++;

        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296)));
    }
}
