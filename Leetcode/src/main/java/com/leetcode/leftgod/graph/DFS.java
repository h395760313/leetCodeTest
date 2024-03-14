package com.leetcode.leftgod.graph;

import com.leetcode.common.Graph;
import com.leetcode.common.Node;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先遍历
 *
 * @author xiehongyu
 * @date 2024/3/14 16:03
 */
public class DFS {

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.print(node.val + "_");
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            for (Node next : n.nexts) {
                if (!set.contains(next)) {
                    stack.push(n);
                    stack.push(next);
                    set.add(next);
                    System.out.print(next.val + "_");
                    break;
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
        GraphGenerator graphGenerator = new GraphGenerator();
        Graph graph = graphGenerator.createGraph(arr);
        dfs(graph.nodes.get(1));
    }
}
