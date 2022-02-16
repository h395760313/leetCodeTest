package com.algorithm.leetCode.背包问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiehongyu
 * @date 2022/02/09 17:13
 */
public class 背包问题 {
    public static void main(String[] args) {
        Article[] articles = new Article[]{
                new Article(35, 10),
                new Article(30, 40),
                new Article(60, 30),
                new Article(50, 50),
                new Article(40, 35),
                new Article(10, 40),
                new Article(25, 30)
        };
        select(articles, "重量主导", (Article a1, Article a2) -> Integer.compare(a1.weight, a2.weight));
        select(articles, "价格主导", (Article a1, Article a2) -> Integer.compare(a2.value, a1.value));
        select(articles, "价格密度主导", (Article a1, Article a2) -> Double.compare(a2.valueDensity , a1.valueDensity));
    }

    private static void select(Article[] articles, String title, Comparator<Article> cmp){
        System.out.println("【"+ title +"】");
        Arrays.sort(articles, cmp);

        int capacity = 150, weight = 0, value = 0;
        List<Article> selectedArticles = new ArrayList<>();
        for (int i = 0; i < articles.length && weight <= capacity; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight += articles[i].weight;
                value += articles[i].value;
                selectedArticles.add(articles[i]);
            }
        }

        System.out.println("总价值：" + value);

        for (int i = 0; i < selectedArticles.size(); i++) {
            System.out.println(selectedArticles.get(i));
        }
    }
}
