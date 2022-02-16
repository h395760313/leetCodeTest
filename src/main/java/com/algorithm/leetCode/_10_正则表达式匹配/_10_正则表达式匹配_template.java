package com.algorithm.leetCode._10_正则表达式匹配;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _10_正则表达式匹配_template {

    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0;
        int len = Math.min(s.length(), p.length());
        return isMatch(s, p, sIndex, pIndex, len);
    }

    public boolean isMatch(String s, String p, int sIndex, int pIndex, int len) {
        if (sIndex >= s.length() || pIndex >= p.length()) {

        }
        if (s.charAt(sIndex) == p.charAt(pIndex)) {
            isMatch(s, p, sIndex + 1, pIndex + 1, len);
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isMatch("aa", "a")));
    }
}
