package com.leetCode.Interview.递归.ms0806_汉诺塔;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class ms0806_汉诺塔_template {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    private void hanota(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            move(a, c);
            return;
        }
        hanota(n - 1, a, c, b);
        move(a, c);
        hanota(n - 1, b, a, c);
    }

    private void move(List<Integer> a, List<Integer> c) {
        Integer data = a.get(a.size() - 1);
        a.remove(a.size() - 1);
        c.add(data);
        System.out.println(data + " from " + a + "->" + c);
    }

    @Test
    public void test() {
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        hanota(a,b,c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
