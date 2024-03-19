package com.leetcode.common;

import org.junit.Test;

import java.util.Comparator;

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

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    @Override
    public String toString() {
        return from + "_" + weight + "_" + to;
    }
}
