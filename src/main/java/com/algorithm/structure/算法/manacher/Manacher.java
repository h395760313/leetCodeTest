package com.algorithm.structure.算法.manacher;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/22 17:05
 */
public class Manacher {

    // 获取最长回文半径
    public int manacher(String s){
        char[] str = manacherStr(s); // 1221 -> #1#2#2#1#
        int[] pArr = new int[str.length]; // 回文半径数组
        int C = -1; // 中心
        int R = -1; // 回文右边界的再往右一个位置 最右的有效区是R-1位置
        int max = Integer.MIN_VALUE; // 扩出来的最大值
        for (int i = 0; i != str.length; i++) { // 每个位置都求回文半径
            // i至少的回文区域，先给pArr[i]
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) pArr[i]++;
                else break;
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            System.out.println("第" + i + "个字符的回文半径为：" + pArr[i]) ;
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    private char[] manacherStr(String s){
        char[] chars = s.toCharArray();
        char[] newChar = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < newChar.length; i++) {
            if ((i & 1) == 0) {
                newChar[i] = '#';
            }else {
                newChar[i] = chars[index++];
            }
        }
        return newChar;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(manacher("abcddsaedea")));
        // #a#b#c#d#d#s#a#e#d#e#a#
        // 12121212321212121612121
    }
}
