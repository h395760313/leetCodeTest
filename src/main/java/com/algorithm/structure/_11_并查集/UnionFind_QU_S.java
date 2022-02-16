package com.algorithm.structure._11_并查集;

/**
 * Quick Union-基于size的优化
 * @author xiehongyu
 * @date 2021/12/21 16:22
 */
public class UnionFind_QU_S extends UnionFind_QU{
    private int[] sizes;

    public UnionFind_QU_S(int capacity) {
        super(capacity);

        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1;
        }
    }

    /**
     *
     */
    public void union(int v1, int v2) {
        int p1 = parents[v1];
        int p2 = parents[v2];
        if (p1 == p2)return;

        if (sizes[p1] > sizes[p2]) {
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }else {
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        }
    }
}
