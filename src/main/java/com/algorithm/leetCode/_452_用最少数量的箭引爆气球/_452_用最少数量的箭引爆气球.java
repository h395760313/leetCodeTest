package com.algorithm.leetCode._452_用最少数量的箭引爆气球;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiehongyu
 * @date 2022/02/09 17:49
 */
public class _452_用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            }else if(o1[0] < o2[0]){
                return -1;
            }else {
                return 0;
            }
        });

        int l = 0; int r = 1;
        int res = points.length;
        int right = points[l][1];
        while (l < points.length && r < points.length) {
            if (points[r][0] <= right) {
                res --;
                right = Math.min(right, points[r][1]);
            }else {
                l = r;
                right = points[l][1];
            }
            r++;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findMinArrowShots(new int[][]{
                {1,2},{2,3},{3,4},{4,5}
        })));
    }
}
