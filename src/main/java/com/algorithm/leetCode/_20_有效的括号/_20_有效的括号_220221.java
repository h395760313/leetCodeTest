package com.algorithm.leetCode._20_有效的括号;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @Author: xiehongyu
 * @Date: 2021/8/5 11:04
 */
public class _20_有效的括号_220221 {
    public boolean isValid(String s) {
        if (s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            }else {
                if (stack.empty() || c != map.get(stack.pop())) return false;
            }
        }
        return stack.empty();
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isValid("(()){[]}")));
    }
}
