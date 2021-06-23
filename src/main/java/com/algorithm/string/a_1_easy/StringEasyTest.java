package com.algorithm.string.a_1_easy;

import org.junit.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 *  说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  示例 1:
 *
 *  输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 *  示例 2:
 *
 *  输入: "race a car"
 * 输出: false
 *
 *  Related Topics 双指针 字符串
 *  👍 388 👎 0
 */
public class StringEasyTest {

    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toLowerCase().toCharArray()) {
            if (((int)c >= (int)'a' && (int)c <= (int)'z') || ((int)c >= (int)'0' && (int)c <= (int)'9')){
                sb.append(c);
            }
        }
        if (sb.length() <= 1) return true;
        int p = 0, q = sb.length() - 1;
        while (p < q) {
            if (sb.charAt(p) != sb.charAt(q)) return false;
            p++;q--;
        }
        return true;
    }


    @Test
    public void stringTest(){
        String str = "0z;z   ; 0";
        System.out.println(isPalindrome(str));
    }
}
