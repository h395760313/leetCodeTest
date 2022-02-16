package com.algorithm.leetCode._605_种花问题;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * @author xiehongyu
 * @date 2022/02/15 16:44
 */
public class _605_种花问题 {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 1) return (flowerbed[0] == 0 ? 1 : 0 ) >= n;
        int res = 0;

        int i = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            res++;
        }
        if (flowerbed[length - 1] == 0 && flowerbed[length - 2] == 0) {
            flowerbed[length - 1] = 1;
            res++;
        }
        for (i = 1; i < length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                res++;
            }
        }
        return res >= n;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(canPlaceFlowers(new int[]{0,0,1,0,0}, 1)));
    }
}
