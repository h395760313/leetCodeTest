package com.leetcode.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiehongyu
 * @date 2024/3/14 14:16
 */
public class Graph {

    public Map<Integer, Node> nodes;
    public Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
