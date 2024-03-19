package com.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiehongyu
 * @date 2024/3/14 14:18
 */
public class Node {

    public int val;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.val = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
