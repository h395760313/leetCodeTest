package com.algorithm.structure._11_并查集;

import com.tools.Asserts;
import com.tools.Times;

/**
 * @author xiehongyu
 * @date 2021/12/21 11:21
 */
public class UnionFindTest {

    private static final int count = 5000000;

    public static void main(String[] args) {

        testTime(new UnionFind_QF(count));
        testTime(new UnionFind_QU(count));
        testTime(new UnionFind_QU_S(count));
        testTime(new UnionFind_QU_R(count));
        testTime(new UnionFind_QU_R_PC(count));
        testTime(new UnionFind_QU_R_PS(count));
        testTime(new UnionFind_QU_R_PH(count));
    }

    static void testTime(UnionFind uf){

        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);
        uf.union(0, 1);


        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(1, 7));

        uf.union(5, 6);
        Asserts.test(uf.isSame(1, 7));

        Times.test(uf.getClass().getSimpleName(), ()->{
            for (int i = 0; i < count; i++) {
                uf.union((int)Math.random() * count, (int)Math.random() * count);
            }
            for (int i = 0; i < count; i++) {
                uf.isSame((int)Math.random() * count, (int)Math.random() * count);
            }
        });
    }
}
