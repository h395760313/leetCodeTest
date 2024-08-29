package com.leetcode.leetcode2024;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 *
 * @Author: xiehongyu
 * @Date: 2024/2/22 20:59
 */
public class _15_三数之和 {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                return res;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] > 0) {
                    i++;
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }


            i++;
        }
        return res;
    }

    @Test
    public void test() {
//        System.out.println(JSON.toJSONString(threeSum(new int[]{0,0,0,0})));

//        Random random1 = new Random();
//        Random random2 = new Random();
//        int num[] = new int[100];
//        for (int i = 0; i < 100; i++) {
//            num[i] = random1.nextInt(100) + -random2.nextInt(100);
//        }
//        System.out.println(JSON.toJSONString(num));

//        System.out.println(JSON.toJSONString(threeSum1(new int[]{23, -21, 0, 28, -24, -18, -86, 85, -71, -5, -14, 38, -38, 31, 15, -51, -11, 3, -41, 60, -91, 6, 17, 18, -31, -5, 1, -24, 17, -90, -16, -36, -19, 26, -33, 3, -77, -1, 19, -49, 52, 14, -37, -3, -62, -37, 10, -69, 3, 21, 24, -51, 35, 53, 22, 11, -68, 0, 21, -12, 37, -27, -6, 29, 69, -53, 63, -24, 4, 75, -33, -17, -39, 50, -43, -11, -36, -38, 32, 7, -11, 45, 16, 32, -22, -33, 89, 7, 33, -8, 18, 63, -6, 39, 91, 7, 19, 70, -33, -46})));
        System.out.println(JSON.toJSONString(threeSum1(new int[]{-1, 0, 1, 2, -1, -4})));
//        System.out.println(JSON.toJSONString(threeSum1(new int[]{-2,0,0,2,2})));
        // -4, -1, -1, 0, 1, 2
    }


}
