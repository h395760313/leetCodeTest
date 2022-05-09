package com.algorithm.leetcode101._01_贪心算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/candy/
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
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
