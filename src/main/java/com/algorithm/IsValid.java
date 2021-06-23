package com.algorithm;

import java.util.Stack;

public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] c = s.toCharArray();
        stack.push(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (stack.size() != 0) {
                if (stack.lastElement() == '(') {
                    if (c[i] == stack.lastElement() + 1) {
                        stack.pop();
                    } else {
                        stack.push(c[i]);
                    }
                } else {
                    if (c[i] == stack.lastElement() + 2) {
                        stack.pop();
                    } else {
                        stack.push(c[i]);
                    }
                }
            } else {
                stack.push(c[i]);
            }
        }
        if (stack.empty())
            return true;

        return false;
    }
}


