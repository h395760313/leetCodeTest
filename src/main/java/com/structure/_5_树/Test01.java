package com.structure._5_树;

import com.alibaba.fastjson.JSON;
import com.leetCode.common.TreeNode;
import com.structure._5_树.a_二叉树.AVLTree;
import com.structure._5_树.a_二叉树.BST;
import com.structure._5_树.a_二叉树.RBTree;
import com.structure._5_树.printer.BinaryTrees;
import com.structure._7_映射.Map;
import com.structure._7_映射.TreeMap;
import com.structure.common.file.FileInfo;
import com.structure.common.file.Files;
import com.tools.Times;
import org.junit.Test;

import java.util.*;


/**
 * @Author: xiehongyu
 * @Date: 2021/8/17 19:55
 */
public class Test01 {

    @Test
    public void Test01(){
//        BinarySearchTree<Person> bst = new BinarySearchTree<>((o1,o2)->o1.getAge() - o2.getAge());
//        bst.add(new Person(12));
//        bst.add(new Person(15));

        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1, 12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int nextInt = random.nextInt(200);
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
//        String s = BinaryTrees.printString(bst) + "\n";
//        Files.writeToFile("/Users/xiehongyu/Desktop/aaa.txt",s,true);
//        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void Test02(){
        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1, 12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
        bst.Traversal(OrderTypeEnum.Preorder.index);
    }

    @Test
    public void Test03(){
        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1, 12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
        bst.Traversal(OrderTypeEnum.inorder.index);
    }

    @Test
    public void Test04(){
        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1, 12};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
        bst.Traversal(OrderTypeEnum.levelorder.index);
    }

    @Test
    public void Test05(){
        Integer[] data = new Integer[]{7 ,4, 9, 2, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
        bst.visit(OrderTypeEnum.postorder.index, element -> System.out.print("_" + element + "_ "));
    }

    @Test
    public void Test06(){
        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
//        bst.visit(OrderTypeEnum.postorder.index, element -> System.out.print("_" + element + "_ "));
        System.out.println(bst.height());
    }

    @Test
    public void Test07(){
        Integer[] data = new Integer[]{4,2,7,1,3,5,6,9};
        AVLTree<Integer> bst = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
//        bst.visit(OrderTypeEnum.postorder.index, element -> System.out.print("_" + element + "_ "));
        bst.remove(4);
        BinaryTrees.println(bst);
    }

    @Test
    public void Test08(){
        Integer[] data = new Integer[]{1,2,3,4,5,6};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        boolean complete = bst.isComplete();
        System.out.println(complete);
        TreeNode root = null;

        System.out.println(JSON.toJSONString(levelOrder(root)));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int queueSize = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            queueSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (queueSize == 0) {
                queueSize = queue.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }



    @Test
    public void Test09(){
//        Integer[] data = new Integer[]{1,2,3,4,5,6,7,8};
        Integer[] data = new Integer[]{13,14,15,12,11,17,16,8,9,1,18};
        AVLTree<Integer> bst = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
        bst.remove(15);
        BinaryTrees.println(bst);

    }
    @Test
    public void Test10(){
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000_000; i++) {
            data.add((int) (Math.random() * 1000_0000));
        }

        BST<Integer> bst = new BST<>();
        Times.test("测试bst添加", ()->{
            for (int i = 0; i < data.size(); i++) {
                bst.add(data.get(i));
            }
        });
        Times.test("测试bst查询", ()->{
            for (int i = 0; i < data.size(); i++) {
                bst.contains(data.get(i));
            }
        });
        Times.test("测试bst删除", ()->{
            for (int i = 0; i < data.size(); i++) {
                bst.remove(data.get(i));
            }
        });

        AVLTree<Integer> avl = new AVLTree<>();
        Times.test("测试avl添加", ()->{
            for (int i = 0; i < data.size(); i++) {
                avl.add(data.get(i));
            }
        });
        Times.test("测试avl查询", ()->{
            for (int i = 0; i < data.size(); i++) {
                avl.contains(data.get(i));
            }
        });
        Times.test("测试avl删除", ()->{
            for (int i = 0; i < data.size(); i++) {
                avl.remove(data.get(i));
            }
        });
    }


    @Test
    public void test10(){
        Integer[] data = new Integer[]{26, 7, 83, 33};
        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
        }

        BinaryTrees.print(rbTree);
    }


    @Test
    public void test11(){
        Integer[] data = new Integer[]{43, 47, 62, 30, 18, 29, 45, 89, 95, 50, 82, 42, 55, 22, 4, 20, 71, 54};
        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
        }
        BinaryTrees.print(rbTree);
        System.out.println("\n-------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            rbTree.remove(data[i]);
            System.out.println("删除节点「" + data[i] + "」");
            BinaryTrees.print(rbTree);
            System.out.println("\n-------------------------------------------");
        }


        BinaryTrees.print(rbTree);
    }

    @Test
    public void test12(){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);
        map.put("dd",4);

        System.out.println(map.containsKey("cc"));
        System.out.println(map.containsValue(5));
    }

    @Test
    public void test13(){

        FileInfo fileInfo = Files.read("/Users/xiehongyu/IdeaProject/Algorithm/src/main/java/com/structure/_e_树/", new String[]{"java"});
        System.out.println("文件数量：" + fileInfo.getFiles());
        System.out.println("文件行数：" + fileInfo.getLines());
        String[] words = fileInfo.words();
        System.out.println("单词数量：" + words.length);

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }

        map.traversal(new Map.Visitor() {
            @Override
            public boolean visit(Object key, Object value) {
                System.out.println(key + "_" + value);
                return false;
            }
        });
    }
}
