package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Edge;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiehongyu
 * @Date: 2024/03/14 20:22
 */
public class Kruskal {

    class Set<T>{
        Map<TreeNode, List<TreeNode>> setMap;

        public Set(List<TreeNode> nodes){
            for (TreeNode node : nodes) {
                setMap.put(node, Arrays.asList(node));
            }
        }

        public boolean isSameSet(TreeNode from, TreeNode to){
            List<TreeNode> fromNodes = setMap.get(from);
            List<TreeNode> toNodes = setMap.get(to);
            return fromNodes == toNodes;
        }

        public void union(TreeNode from, TreeNode to){
            List<TreeNode> fromNodes = setMap.get(from);
            List<TreeNode> toNodes = setMap.get(to);
            for (TreeNode toNode : toNodes) {
                fromNodes.add(toNode);
                setMap.put(toNode, fromNodes);
            }
        }

    }

    public Set<Edge> kruskalMST(Graph graph){

    }
    @Test
    public void test() {

    }
}
