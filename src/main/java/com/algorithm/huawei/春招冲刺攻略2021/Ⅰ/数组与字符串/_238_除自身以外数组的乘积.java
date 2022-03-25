package com.algorithm.huawei.春招冲刺攻略2021.Ⅰ.数组与字符串;

import com.alibaba.fastjson.JSON;

/**
 * @author xiehongyu
 * @date 2022-03-16
 */
public class _238_除自身以外数组的乘积 {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] post = new int[len];;
        int[] res = new int[len];
        res[0] = 1;
        post[len - 1] = 1;
        int preRes = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = res[i] * post[i];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
