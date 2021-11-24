package com.leetCode._6_Z字形变换;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _6_211123 {

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows < 2) return s;
        int flag = 1, row = 0;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && i % (numRows - 1) == 0) {
                flag *= -1;
            }
            list.get(row).append(s.charAt(i));
            row += flag;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(convert("PAYPALISHIRING",3)));
    }
}
