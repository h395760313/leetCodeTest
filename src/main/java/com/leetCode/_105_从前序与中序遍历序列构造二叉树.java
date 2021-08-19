package com.leetCode;

import com.alibaba.fastjson.JSON;
import com.leetCode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author: xiehongyu
 * @Date: 2021/8/19 16:18
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootElement = preorder[0];
        List<Integer> leftData = new ArrayList<>(preorder.length);
        int rootIndex = preorder.length;
        List<Integer> rightData = new ArrayList<>(preorder.length);

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootElement){
                rootIndex = i;
                continue;
            }
            if (i <= rootIndex) {
                leftData.add(inorder[i]);
            }else {
                rightData.add(inorder[i]);
            }
        }
        System.out.println(JSON.toJSONString(leftData));
        System.out.println(JSON.toJSONString(rightData));
        return null;
    }

    @Test
    public void test() {
        buildTree(new int[]{4,2,1,3,6,5},new int[]{1,2,3,4,5,6});
    }
}
