package com.leetcode.leetcode2024;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/
 *
 * @Author: xiehongyu
 * @Date: 2024/09/02 21:40
 */
public class _2734_执行子串操作后的字典序最小字符串 {


    public String smallestString(String s) {
        if (s.length() < 1) {
            return s;
        }
        char[] charArray = s.toCharArray();

        int aIndex = s.indexOf("a");
        // 存在a
        if (aIndex != -1) {
            // 如果全是a
            int i1 = 0;
            while (i1 < s.length()) {
                if (s.charAt(i1) != 'a') {
                    break;
                }
                i1++;
            }
            if (i1 == s.length()) {
                charArray[s.length() - 1] = 'z';
                return String.valueOf(charArray);
            }

            // 不是全a
            if (aIndex == 0) {
                // a是开头几个
                int subIndex = 1;
                while (subIndex < charArray.length && charArray[subIndex] == 'a') {
                    subIndex++;
                }
                String str = s.substring(subIndex);
                int secondIndex = str.indexOf("a");
                int last = charArray.length;
                if (secondIndex != -1) {
                    last = secondIndex + subIndex;
                }
                for (int i = subIndex; i < last; i++) {
                    charArray[i] = (char) (charArray[i] - 1);
                }
            } else {
                // a不是开头
                for (int i = 0; i < aIndex; i++) {
                    charArray[i] = (char) (charArray[i] - 1);
                }
            }
            return String.valueOf(charArray);
        }

        // 不存在a，全部-1
        int index = 0;

        while (index < charArray.length) {
            charArray[index] = (char) (charArray[index] - 1);
            index++;
        }
        return String.valueOf(charArray);
    }

    @Test
    public void test() {
        System.out.println(smallestString("aba"));
    }

}
