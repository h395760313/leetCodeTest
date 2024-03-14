package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiehongyu
 * @date 2024/3/14 09:31
 */
public class SerializeAndReconstructTree {


    public String serializeTree(TreeNode head) {
        if (head == null) {
            return "#_";
        }
        String res = head.val + "_";
        res += serializeTree(head.left);
        res += serializeTree(head.right);
        return res;
    }

    public TreeNode reconstruct(String str) {
        String[] nodes = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            queue.add(nodes[i]);
        }
        return consume(queue);
    }

    private TreeNode consume(Queue<String> queue) {
        String node = queue.poll();
        if ("#".equals(node)) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(node));
        head.left = consume(queue);
        head.right = consume(queue);
        return head;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(7);
        String s = serializeTree(node);
        TreeNode res = reconstruct(s);
        System.out.println(s);
        PreInPosTraversal preInPosTraversal = new PreInPosTraversal();
        preInPosTraversal.preOrderRecur(res);
//        System.out.println(res);
    }
}
