package com.algorithm.structure._11_并查集;

/**
 * Quick Union - 基于rank优化 - 路径分裂(Path Spliting)
 * @author xiehongyu
 * @date 2021/12/21 17:03
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R{

    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);

        while (parents[v] != v) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return parents[v];
    }
}
