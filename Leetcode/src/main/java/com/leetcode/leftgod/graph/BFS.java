package com.leetcode.leftgod.graph;

import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先遍历
 *
 * @author xiehongyu
 * @date 2024/3/14 15:45
 */
public class BFS {

    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.val + "_");
            for (Node next : n.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }


    @Test
    public void test() {
        Integer[][] arr = new Integer[][]{
                {1, 2, 1}, {1, 3, 1}, {1, 5, 1},
                {2, 1, 1}, {2, 3, 1}, {2, 4, 1}, {2, 5, 1},
                {3, 1, 1}, {3, 2, 1}, {3, 4, 1},
                {4, 2, 1}, {4, 3, 1}, {4, 5, 1},
                {5, 1, 1}, {5, 2, 1}, {5, 4, 1}};
        Graph graph = GraphGenerator.createGraph(arr);
        bfs(graph.nodes.get(1));
    }
}
