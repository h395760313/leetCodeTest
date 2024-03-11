package com.leetcode.leftgod.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 荷兰国旗问题
 *
 * @author xiehongyu
 * @date 2024/3/11 10:03
 */
public class FlagOfTheNetherlands {

    public void flagOfTheNetherlands(int[] arr, int target) {
        int l = -1;
        int r = 1;
        while (r < arr.length) {
            if (arr[r] <= target) {
                swap(arr, ++l, r);
            }
            r++;
        }
        System.out.println(JSON.toJSONString(arr));
    }

    public void flagOfTheNetherlands2(int[] arr, int target) {
        int l = -1;
        int r = arr.length;
        int i = 0;
        while (i < r) {
            if (arr[i] <= target) {
                swap(arr, ++l, i++);
            } else {
                swap(arr, --r, i++);
            }
        }
        System.out.println(JSON.toJSONString(arr));
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void test() {
        flagOfTheNetherlands2(new int[]{8, 5, 3, 9, 4, 7, 1, 2, 6, 0}, 5);
    }
}
