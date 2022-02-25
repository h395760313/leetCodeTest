package com.algorithm.leetCode._17_电话号码的字母组合;

import org.junit.Test;

import java.util.*;

/**
 * @author xiehongyu
 * @date 2022/02/22 12:03
 */
public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        digits = digits.replace("1","");
        if (digits.length() < 1) return Arrays.asList();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l',});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = map.get(digits.charAt(i));
            list.add(chars);
        }
        List<String> res = new ArrayList<>();
        dfs(res,"", list, 0);
        return res;
    }

    private void dfs(List<String> res, String str, List<char[]> list, int n){
        if (n == list.size()) {
            return;
        }
        char[] chars = list.get(n);
        for (char c : chars) {
            dfs(res, str + c, list, n + 1);
            if (str.length() == list.size() - 1) res.add(str + c);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("12345"));
    }
}
