package com.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/24 12:12
 */
@Slf4j
public class _t04_最长公共前缀 {


    @Test
    public void test() {
        String[] strs = {"flowers", "flight", "flow"};
        LinkedList<Character> list = new LinkedList<>();
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            list.add(first.charAt(i));
        }

        int res = first.length();
        String resStr = "";
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == first.charAt(j)) {
                    len++;
                    sb.append(str.charAt(j));
                }
            }
            if (len <= res) {
                res = len;
                resStr = sb.toString();
            }
        }
        System.out.println(resStr);
    }

    class Node {
        char c;
        Node next;

        public Node(char c) {
            this.c = c;
        }

        public Node() {
        }

        public Node addStrOne(String[] strs) {
            Node cur = this;
            for (int j = 0; j < strs[0].length(); j++) {
                char ch = strs[0].charAt(j);
                cur = new Node(ch);
                cur = cur.next;
            }
            return this;
        }
    }
}
