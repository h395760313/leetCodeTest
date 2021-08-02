package Algorithm;

import com.algorithm.GreedyAlgorithm;
import com.algorithm.GreedyAlgorithm2;
import org.junit.Test;


public class GreedyAlgorithmTest {

    GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
    GreedyAlgorithm2 greedyAlgorithm2 = new GreedyAlgorithm2();

    /**
     * 455.分发饼干(Assign Cookies)
     */
    @Test
    public void findContentChildrenTest(){
        int[] g = {1,2} ,s = {1,2,3};
        System.out.println(greedyAlgorithm2.findContentChildren(g,s));
    }

    /**
     * 135.分发糖果(Candy)
     */
    @Test
    public void candyTest(){
        int[] g = {1,3,4,5,2};
        System.out.println(greedyAlgorithm2.candy(g));
    }

    /**
     * 435.无重叠区间(Non-overlapping Intervals)
     */
    @Test
    public void eraseOverlapIntervalsTest(){
        int[][] g = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(greedyAlgorithm2.eraseOverlapIntervals(g));
    }

    /**
     * 605.种花问题(Can Place Flowers)
     */
    @Test
    public void canPlaceFlowersTest(){
        int[] g = {1,0,0,0,1};
        System.out.println(greedyAlgorithm.canPlaceFlowers(g,1));
    }

    /**
     * 452.用最少数量的箭引爆气球(Minimum Number of Arrows to Burst Balloons)
     */
    @Test
    public void findMinArrowShotsTest(){
        int[][] g = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(greedyAlgorithm.findMinArrowShots(g));
    }

    /**
     * 763.划分字母区间(Partition Labels)
     */
    @Test
    public void partitionLabelsTest() {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(greedyAlgorithm.partitionLabels(s));
    }

    /**
     * 122.买卖股票的最佳时机 II(Best Time to Buy and Sell Stock II)
     */
    @Test
    public void maxProfit2Test() {
        int[] g = {7,6,4,3,1};
        System.out.println(greedyAlgorithm.maxProfit(g));
    }


    /**
     * 406.根据身高重建队列(Queue Reconstruction by Height)
     */
    @Test
    public void reconstructQueueTest() {
        int[][] g = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(greedyAlgorithm.reconstructQueue(g));
    }

    /**
     * 665.非递减数列(Non-decreasing Array)
     */
    @Test
    public void checkPossibilityTest() {
        int[] g = {4,2,1};
        System.out.println(greedyAlgorithm.checkPossibility(g));
    }
}