package com.leetCode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _6_Z字形变换 {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        if (s.length() < 2) return s;
        List<StringBuffer> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int flag = 1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            list.add(list.get(row).append(s.charAt(i)));
            if (i != 0) if (row == numRows -1 || row == 0) flag = -flag;
            row += flag;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(convert("PAYPALISHIRING",3)));
    }
}
