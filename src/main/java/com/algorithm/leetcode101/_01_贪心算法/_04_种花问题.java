package com.algorithm.leetcode101._01_贪心算法;

import com.sun.org.apache.bcel.internal.generic.IFGE;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/can-place-flowers/
 * @Author: xiehongyu
 * @Date: 2022/05/09 16:35
 */
public class _04_种花问题 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (n == 0) return true;
        if (len < n) {
            return false;
        }
        if (len == 1) {
            if (n == 1 && flowerbed[0] == 0) {
                return true;
            } else {
                return false;
            }
        }
        int count = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }

        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }

        }

        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            count++;
        }

        return count >= n;
    }

    @Test
    public void test() {
        System.out.println(canPlaceFlowers(new int[]{1}, 0));
    }
}
