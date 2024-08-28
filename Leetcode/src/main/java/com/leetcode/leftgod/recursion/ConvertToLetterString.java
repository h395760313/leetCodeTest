package com.leetcode.leftgod.recursion;

import org.junit.Test;

/**
 * 数字转换为字母字符串
 *
 * @Author: xiehongyu
 * @Date: 2024/03/26 15:34
 */
public class ConvertToLetterString {


    public int convertToLetterString(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private int process(char[] arr, int i) {
        if (i == arr.length) {
            return 1;
        }
        if (arr[i] == 0) {
            return 0;
        }
        if (arr[i] == '1') {
            int res = process(arr, i + 1);
            if (i + 1 < arr.length) {
                res += process(arr, i + 2);
            }
            return res;
        } else if (arr[i] == '2') {
            int res = process(arr, i + 1);
            if (i + 1 < arr.length && arr[i + 1] <= '6') {
                res += process(arr, i + 2);
            }
            return res;
        }
        return process(arr, i + 1);
    }


    @Test
    public void test() {
        System.out.println(convertToLetterString("111"));
    }
}
