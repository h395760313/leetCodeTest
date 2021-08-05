package com.leetCode;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 * 思路：首先长度处理：当字符串长度小于2时返回自己；在字符串中拼接一个符号，
 */

public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s.length() < 2 ) return s;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append('#');
        String str = sb.toString();

        int maxLen = 0;
        String res = "";
        for (int center = 0; center < str.length(); center++) {
            int x = center - 1;
            int y = center + 1;
            int tempLen = 0;
            while (x >= 0 && y < str.length() && x < y){
                System.out.println("center : "  +str.charAt(center) +"    "+x+" : "+str.charAt(x) +",    "+y+" : "+str.charAt(y)+"    tempLen:"+tempLen);

                if (str.charAt(x) != str.charAt(y)){
                    break;
                }
                tempLen ++;
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                    res = s.substring(x / 2,(y+1) / 2);
                }
                x--;y++;
            }

        }
        System.out.println(maxLen);
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(longestPalindrome("ac")));
    }
}
