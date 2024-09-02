package com.leetcode.leetcode.leetcode2024;

import cn.hutool.json.JSONUtil;
import com.leetcode.common.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * @Author: xiehongyu
 * @Date: 2024/09/02 21:42
 */
public class _102_二叉树的层序遍历 {

    private List<List<Integer>> process(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        int lastLevel = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode node = poll.getKey();
            Integer level = poll.getValue();
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
            if (level != lastLevel) {
                res.add(list);
                list = new ArrayList<>();
                lastLevel++;
            }
            list.add(node.val);
        }
        res.add(list);
        return res;
    }


    static List<List<Integer>> res = new ArrayList<>();

    private void process2(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        process2(node.left, level + 1);
        process2(node.right, level + 1);
    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        process2(treeNode, 0);
        System.out.println(JSONUtil.toJsonStr(res));
    }


}
