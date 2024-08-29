package com.leetcode.huawei;

import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/24 11:49
 */
@Slf4j
public class _t02_取最长元音字符串 {


    @Test
    public void test() {
        int res = 0;
        Set<Character> set = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
                .stream()
                .collect(Collectors.toSet());

        String str = "asdbuiodevauufgh";
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                continue;
            }
            int len = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (!set.contains(str.charAt(j))) {
                    break;
                }
                len++;
            }
            res = Math.max(len, res);
        }
        System.out.println(res);

    }
}
