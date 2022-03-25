package com.algorithm.huawei.春招冲刺攻略2021.Ⅱ.哈希表;

import com.alibaba.fastjson.JSON;

/**
 * @author xiehongyu
 * @date 2022-03-17
 */
public class _974_和可被K整除的子数组 {

    public static int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5)));
    }

    // 4,5,0,-2,-3,1
    // 0,4,9,9,7,4,5
    //
}
