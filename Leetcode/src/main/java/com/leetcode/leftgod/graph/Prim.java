package com.leetcode.leftgod.graph;

import com.leetcode.common.Edge;
import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: xiehongyu
 * @Date: 2024/03/19 22:29
 */
public class Prim {


    public Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Edge.EdgeComparator());
        Set<Edge> result = new HashSet<>();
        Set<Node> set = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            set.add(node);
            for (Edge edge : node.edges) {
                queue.add(edge);
            }
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                Node toNode = edge.to;
                if (!set.contains(toNode)) {
                    result.add(edge);
                    set.add(toNode);
                    for (Edge edge1 : toNode.edges) {
                        queue.add(edge1);
                    }
                }
            }
            break;
        }
        return result;
    }

    @Test
    public void test() {
        Integer[][] arr = new Integer[][]{
                {1, 2, 6}, {1, 3, 1}, {1, 4, 5},
                {2, 1, 6}, {2, 3, 5}, {2, 5, 3},
                {3, 1, 1}, {3, 2, 5}, {3, 4, 5}, {3, 5, 6}, {3, 6, 4},
                {4, 1, 5}, {4, 3, 5}, {4, 6, 2},
                {5, 2, 3}, {5, 3, 6}, {5, 6, 6},
                {6, 3, 4}, {6, 4, 2}, {6, 5, 6}};
        System.out.println(primMST(GraphGenerator.createGraph(arr)));
    }
}
