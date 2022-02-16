package com.algorithm.structure._11_并查集;

/**
 * Quick Union - 基于rank优化 - 路径压缩(Path Compression)
 * @author xiehongyu
 * @date 2021/12/21 16:55
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R{
    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);

        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
