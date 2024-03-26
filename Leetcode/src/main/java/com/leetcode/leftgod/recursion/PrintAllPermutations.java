package com.leetcode.leftgod.recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串所有子序列
 * @Author: xiehongyu
 * @Date: 2024/03/26 13:58
 */
public class PrintAllPermutations {


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
            return;
        }
        List<String> originList = new ArrayList<>();

        copyList(list, originList);
        for (int j = 0; j < originList.size(); j++) {
            list.add(list.get(j) + charArray[i]);
        }
        dp(charArray, i + 1, list);
        dp(charArray, i + 1, originList);
    }


    private void copyList(List<String> from, List<String> to){
        for (int i = 0; i < from.size(); i++) {
            to.add(from.get(i));
        }
    }

    @Test
    public void test() {
        printAllPermutations("abc");
    }
}
