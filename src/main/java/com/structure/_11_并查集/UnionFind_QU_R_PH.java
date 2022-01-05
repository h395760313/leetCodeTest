package com.structure._11_并查集;

/**
 * Quick Union - 基于rank优化 - 路径减半(Path Halving)
 * @author xiehongyu
 * @date 2021/12/21 17:08
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R{

    public UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);

        while (parents[v] != v) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return parents[v];
    }
}
