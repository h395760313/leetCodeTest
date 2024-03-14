package com.leetcode.leftgod.graph;

import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.*;

/**
 * 拓扑排序算法
 *
 * @author xiehongyu
 * @date 2024/3/14 16:55
 */
public class TopologySort {

    public List<Node> sortedTopology(Graph graph) {
        // key: 某一个节点
        // value：剩余的入度
        Map<Node, Integer> inMap = new HashMap<>();
        // 入度为0的节点才进入队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        Map<Integer, Node> nodes = graph.nodes;
        for (Node node : nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }


    @Test
    public void test() {
        Integer[][] arr = new Integer[][]{
                {1, 2, 1}, {1, 3, 1},
                {2, 3, 1}, {2, 4, 1},
                {3, 4, 1}};
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.createGraph(arr);
        List<Node> nodes = sortedTopology(graph);
        for (Node node : nodes) {
            System.out.print(node.val + "_");
        }
    }
}
