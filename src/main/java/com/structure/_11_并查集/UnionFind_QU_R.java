package com.structure._11_并查集;

/**
 * Quick Union-基于rank的优化
 * @author xiehongyu
 * @date 2021/12/21 16:41
 */
public class UnionFind_QU_R extends UnionFind_QU{
    private int[] ranks;

    public UnionFind_QU_R(int capacity) {
        super(capacity);

        ranks = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    /**
     *
     */
    public void union(int v1, int v2) {
        int p1 = parents[v1];
        int p2 = parents[v2];
        if (p1 == p2) return;

        if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        }else if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        }else {
            parents[p1] = p2;
            ranks[p2]++;
        }
    }
}
