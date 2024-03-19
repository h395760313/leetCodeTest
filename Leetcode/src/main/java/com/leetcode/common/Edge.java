package com.leetcode.common;

import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2024/3/14 14:18
 */

public class Edge {

    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return from + "_" + weight + "_" + to;
    }
}
