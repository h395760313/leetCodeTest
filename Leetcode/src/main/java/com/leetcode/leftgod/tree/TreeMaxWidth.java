package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author xiehongyu
 * @date 2024/3/13 16:49
 */
public class TreeMaxWidth {

    /**
     * 1）使用队列
     * 2）记录层级、每个元素所在层级、层级节点数
     * 3）弹出队列时判断弹出元素层级是否是记录的当前层级。
     * 4）如果是当前层级，那么记录层级节点数+1
     * 5）如果不是当前层级，那么计算上一层的节点数是否为当前最多节点数，当前层级+1，层级节点数归1
     * 6）将当前节点的左节点和右节点推入队列，哈希表记录左右节点的层级为当前层级+1
     * 6）循环3）-> 4）or 5）->6）
     * @param head
     * @return
     */
    public int treeMaxWidth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int curLevel = 1;
        int levelCount = 0;
        int max = -1;
        Map<TreeNode, Integer> nodeLevel = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer level = nodeLevel.getOrDefault(node, 1);
            if (level == curLevel) {
                levelCount++;
            } else {
                max = Math.max(max, levelCount);
                curLevel = level;
                levelCount = 1;
            }
            if (node.left != null) {
                queue.add(node.left);
                nodeLevel.put(node.left, curLevel + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                nodeLevel.put(node.right, curLevel + 1);
            }
        }
        return max;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(8);
        node.left.right.left.right = new TreeNode(9);
        node.right.left = new TreeNode(6);
        node.right.left.left = new TreeNode(10);
        node.right.left.right = new TreeNode(11);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(12);
        node.right.right.right.right = new TreeNode(13);

        System.out.println(treeMaxWidth(node));
    }
}
