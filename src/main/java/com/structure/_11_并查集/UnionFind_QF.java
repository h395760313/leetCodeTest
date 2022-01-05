package com.structure._11_并查集;

/**
 * quick find
 * @author xiehongyu
 * @date 2021/12/21 11:34
 */
public class UnionFind_QF extends UnionFind {

    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 父节点就是根节点
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 将v1所在的集合中所有元素都嫁接搭配v2的父节点上
     */
    @Override
    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }


}
