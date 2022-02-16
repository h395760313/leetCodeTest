package com.algorithm.leetCode._122_买卖股票的最佳时机II;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author xiehongyu
 * @date 2022/2/15 16:10
 */
public class _122_买卖股票的最佳时机II {


    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
                res -= prices[i];
                while (prices[i + 1] > prices[i] && i < prices.length - 2) {
                    i++;
                }
                res += Math.max(prices[i + 1], prices[i]);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(maxProfit(new int[]{7,1,5,3,6,4})));
    }
}
