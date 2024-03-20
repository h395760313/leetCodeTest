package com.leetcode.leftgod.tria;

import org.junit.Test;
import sun.reflect.generics.tree.ReturnType;

/**
 * @Author: xiehongyu
 * @Date: 2024/03/20 13:38
 */
public class TriaNode {

    public int pass;
    public int end;
    public TriaNode[] nexts;   // HashMap<Char, Node> nexts;

    public TriaNode(){
        pass = 0;
        end = 0;
        // next[0] == null 没有走向'a'的路
        // next[0] != null 有走向'a'的路
        // ...
        // next[25] != null 有走向'z'的路
        nexts = new TriaNode[26];
    }

    public static class Node{
        private TriaNode root;

        public Node(){
            root = new TriaNode();
        }

        public void insert(String word){
            if (word == null) {
                return;
            }
            root.pass++;
            char[] chs = word.toCharArray();
            int index = 0;
            TriaNode node = root;

            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TriaNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public int search(String word){
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            int index = 0;
            TriaNode node = root;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String word){
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            int index = 0;
            TriaNode node = root;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }


        public void delete(String word){
            if (search(word)!= 0) {
                char[] chs = word.toCharArray();
                int index = 0;
                TriaNode node = root;
                node.pass--;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

    }

}
