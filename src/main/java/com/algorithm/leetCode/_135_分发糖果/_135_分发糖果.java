package com.algorithm.leetCode._135_分发糖果;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * @author xiehongyu
 * @date 2022/02/15 17:05
 */
public class _135_分发糖果 {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int res = 0;
        int[] sugar = new int[len];
        Arrays.fill(sugar,1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1] && sugar[i] <= sugar[i - 1]) {
                sugar[i] = sugar[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && sugar[i] <= sugar[i + 1]) {
                sugar[i] = sugar[i + 1] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            res += sugar[i];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(candy(new int[]{1,2,3,4,5,6})));
    }
}
