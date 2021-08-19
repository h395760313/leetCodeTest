package com.structure.e_二叉搜索树;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.structure.file.Files;
import com.structure.printer.BinaryTrees;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


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
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int nextInt = random.nextInt(200);
            bst.add(nextInt);
            list.add(nextInt);
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
        Integer[] data = new Integer[]{7 ,4, 9, 2, 5, 8, 11, 3, 1, 12};
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
        Integer[] data = new Integer[]{4,2,7,1,3,6,9};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            int nextInt = data[i];
            bst.add(nextInt);
        }
        BinaryTrees.println(bst);
//        bst.visit(OrderTypeEnum.postorder.index, element -> System.out.print("_" + element + "_ "));
        System.out.println(bst.isComplete());
    }


}
