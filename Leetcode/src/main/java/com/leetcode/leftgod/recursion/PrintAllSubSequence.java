package com.leetcode.leftgod.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 打印字符串所有全排列
 * @Author: xiehongyu
 * @Date: 2024/03/26 13:58
 */
public class PrintAllSubSequence {


    public void printAllPermutations(String str){
        List<String> res = new ArrayList<>();
        res.add("");
        dp(str.toCharArray(), 0, res);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private void dp(char[] charArray, int i, List<String> list) {
        if (i == charArray.length) {
            list.add(String.valueOf(charArray));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < charArray.length; j++) {
            if (!visit[charArray[j] - 'a']) {
                visit[charArray[j] - 'a'] = true;
                swap(charArray, i, j);
                dp(charArray, i+1, list);
                swap(charArray, i, j);
            }
        }
    }


    private void swap(char[] chars, int i, int j){
        char tem = chars[i];
        chars[i] = chars[j];
        chars[j] = tem;
    }

    @Test
    public void test() {
        printAllPermutations("aabbcc");
    }
}
