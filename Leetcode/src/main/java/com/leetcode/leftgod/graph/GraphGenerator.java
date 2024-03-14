package com.leetcode.leftgod.graph;

import com.leetcode.common.Edge;
import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2024/3/14 14:49
 */
public class GraphGenerator {

    public Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

    @Test
    public void test() {
        System.out.println();
    }
}
