package com.leetCode;

import com.alibaba.fastjson.JSON;
import com.structure.c_栈.Stack;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @Author: xiehongyu
 * @Date: 2021/8/5 11:04
 */
public class _20_有效的括号 {
    public boolean isValid1(String s) {
        /**
         *  执行耗时:41 ms,击败了5.36% 的Java用户
         * 	内存消耗:39.1 MB,击败了5.01% 的Java用户
         */
        while (s.contains("{}") || s.contains("[]") || s.contains("()")){
            s = s.replace("{}","");
            s = s.replace("[]","");
            s = s.replace("()","");
        }
        return s.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                if(c != map.get(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(isValid2("((")));
    }
}
