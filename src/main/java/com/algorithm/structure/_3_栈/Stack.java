package com.algorithm.structure._3_栈;


import com.algorithm.structure._1_动态数组.ArrayList;
import com.algorithm.structure.inter.List;

/**
 * @Author: xiehongyu
 * @Date: 2021/7/31 16:25
 */
public class Stack<E>{

    private List<E> list = new ArrayList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public E top(){
        return list.get(list.size() - 1);
    }

}
