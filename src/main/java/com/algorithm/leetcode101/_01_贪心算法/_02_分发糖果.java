package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/candy/
 * @Author: xiehongyu
 * @Date: 2022/05/09 15:27
 */
public class _02_分发糖果 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
                candy[i] = candy[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < candy.length; i++) {
            res += candy[i];
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(candy(new int[]{1,3,4,5,2}));
    }
}
