package com.leetcode.leftgod.graph;

import com.leetcode.common.Edge;
import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.*;


/**
 * @Author: xiehongyu
 * @Date: 2024/03/14 20:22
 */
public class Kruskal {

    static class Set<T> {
        Map<Node, List<Node>> setMap = new HashMap<>();

        public Set(Collection<Node> nodes) {
            for (Node node : nodes) {
                ArrayList<Node> list = new ArrayList<>();
                list.add(node);
                setMap.put(node, list);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromNodes = setMap.get(from);
            List<Node> toNodes = setMap.get(to);
            return fromNodes == toNodes;
        }

        public void union(Node from, Node to) {
            List<Node> fromNodes = setMap.get(from);
            List<Node> toNodes = setMap.get(to);
            for (Node toNode : toNodes) {
                fromNodes.add(toNode);
                setMap.put(toNode, fromNodes);
                setMap.put(from, fromNodes);
            }
        }
    }

    public java.util.Set<Edge> kruskalMST(Graph graph) {
        Map<Integer, Node> nodes = graph.nodes;
        Set<Node> set = new Set<>(nodes.values());
        java.util.Set<Edge> result = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Edge.EdgeComparator());
        queue.addAll(graph.edges);
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (!set.isSameSet(edge.from, edge.to)) {
                set.union(edge.from, edge.to);
                result.add(edge);
            }
        }
        return result;
    }

    @Test
    public void test() {
        Integer[][] arr = new Integer[][]{
                {1, 2, 11}, {1, 3, 10}, {1, 4, 7},
                {2, 3, 15}, {2, 4, 100},
                {3, 4, 2}};
        System.out.println(kruskalMST(GraphGenerator.createGraph(arr)));
    }
}
