package com.algorithm.structure._5_树.b_前缀树;


/**
 * @author xiehongyu
 * @date 2022/02/17 16:54
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.isEmpty()) return;
        char[] chars = word.toCharArray();

        TrieNode node = root;
        node.pass++;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (word.isEmpty() || search(word) == 0) return;

        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass--;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (--node.nexts[index].pass == 0) {
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    /**
     * 查询有多少个这个字符串
     * @param word
     * @return
     */
    public int search(String word){
        if (word.isEmpty()) return root.pass;

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }
    /**
     * 查询有多少个这个字符串作为前缀
     * @param word
     * @return
     */
    public int prefixNumber(String word){
        if (word.isEmpty()) return root.pass;

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public static class TrieNode{
        int pass;
        int end;
        TrieNode[] nexts;  // HashMap<Character, TrieNode> nexts
        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            // nexts[0] == null 没有到'a'的路
            // nexts[0] != null 有到'a'的路
            // ...
            // nexts[25] = null 有到'z'的路
            nexts = new TrieNode[26];
        }
    }


    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("abc");
        tree.insert("acd");
        tree.insert("abcd");
        tree.insert("abce");

        System.out.println(tree.search("abc"));
        System.out.println(tree.search("abcdf"));
        System.out.println(tree.search("abce"));
        System.out.println(tree.prefixNumber("abc"));
        tree.delete("abce");
        System.out.println(tree.search("abc"));
        System.out.println(tree.search("abcdf"));
        System.out.println(tree.search("abce"));
        System.out.println(tree.prefixNumber("abc"));

    }
}
