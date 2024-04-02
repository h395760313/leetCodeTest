package com.leetcode.leftgod.union;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiehongyu
 * @date 2024/4/2 19:23
 */
public class UnionFindSetTest {

    @Test
    public void test() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        UnionFindSet<String> unionFindSet = new UnionFindSet<>(list);
        System.out.println(unionFindSet.isSameSet("a", "b"));
        unionFindSet.union("a", "b");
        System.out.println(unionFindSet.isSameSet("a", "b"));
    }
}
