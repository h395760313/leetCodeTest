package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最低公共祖先
 * @Author: xiehongyu
 * @Date: 2024/03/13 22:30
 */
public class LowestCommonAncestor {

    /**
     * n1、n2一定属于head为头的树
     * 返回o1、o2最低公共祖先
     */
    public TreeNode lca(TreeNode head, TreeNode n1, TreeNode n2){
        Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);

        Set<TreeNode> set1 = new HashSet<>();
        TreeNode cur = n1;
        while (cur != fatherMap.get(cur)){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        cur = n2;
        while (cur != fatherMap.get(cur)) {
            if (set1.contains(cur)){
                return cur;
            }
            cur = fatherMap.get(cur);
        }
        return head;
    }

    private void process(TreeNode head, Map<TreeNode, TreeNode> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public TreeNode lca2(TreeNode head, TreeNode n1, TreeNode n2){
        if (head == null || head == n1 || head == n2) {
            return head;
        }
        TreeNode left = lca2(head.left, n1, n2);
        TreeNode right = lca2(head.right, n1, n2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(lca2(node, node.left.left, node.right.right).val);
    }
}
