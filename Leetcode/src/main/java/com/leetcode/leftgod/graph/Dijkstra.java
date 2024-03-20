package com.leetcode.leftgod.graph;

import com.leetcode.common.Edge;
import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: xiehongyu
 * @Date: 2024/03/20 13:11
 */
public class Dijkstra {

    public Map<Node, Integer> dijkstra1(Node node) {
        Map<Node, Integer> result = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        result.put(node, 0);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (Edge edge : poll.edges) {
                if (!result.containsKey(edge.to)) {
                    result.put(edge.to, result.getOrDefault(edge.from, 0) + edge.weight);
                    queue.add(edge.to);
                } else {
                    int min = Math.min(result.getOrDefault(edge.from, 0) + edge.weight, result.get(edge.to));
                    result.put(edge.to, min);
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        Integer[][] arr = new Integer[][]{
                {1, 2, 3}, {1, 3, 15}, {1, 4, 9},
                {2, 1, 3}, {2, 3, 2}, {2, 5, 200},
                {3, 1, 15}, {3, 2, 2}, {3, 4, 7}, {3, 5, 14},
                {4, 1, 9}, {4, 3, 7}, {4, 5, 16},
                {5, 2, 200}, {5, 3, 14}, {5, 4, 16}};
        Graph graph = GraphGenerator.createGraph(arr);
        Node node = graph.nodes.get(1);
        System.out.println(dijkstra1(node));
    }
}
