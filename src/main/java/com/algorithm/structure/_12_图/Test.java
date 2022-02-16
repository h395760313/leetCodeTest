package com.algorithm.structure._12_图;

/**
 * @author xiehongyu
 * @date 2021/12/30 16:04
 */
public class Test {

    public static void main(String[] args) {
        Graph<String, Integer> graph = new ListGraph<>();

//        graph.addEdge("v1", "v0", 9);
//        graph.addEdge("v1", "v2", 3);
//        graph.addEdge("v2", "v0", 2);
//        graph.addEdge("v2", "v3", 5);
//        graph.addEdge("v3", "v4", 1);
//        graph.addEdge("v0", "v4", 6);

//        graph.removeEdge("v0", "v4");
//        graph.removeVertex("v0");

//        graph.print();


//        graph.addEdge("v0", "v1", 6);
//        graph.addEdge("v1", "v0", 6);
//
//        graph.addEdge("v0", "v2", 6);
//        graph.addEdge("v2", "v0", 6);
//
//        graph.addEdge("v0", "v4", 6);
//        graph.addEdge("v4", "v0", 6);
//
//        graph.addEdge("v1", "v2", 6);
//        graph.addEdge("v2", "v1", 6);
//
//        graph.addEdge("v2", "v3", 6);
//        graph.addEdge("v3", "v2", 6);
//
//        graph.addEdge("v3", "v4", 6);
//        graph.addEdge("v4", "v3", 6);

        graph.addEdge("A", "B", null);
        graph.addEdge("B", "A", null);

        graph.addEdge("A", "F", null);
        graph.addEdge("F", "A", null);

        graph.addEdge("B", "G", null);
        graph.addEdge("G", "B", null);

        graph.addEdge("F", "G", null);
        graph.addEdge("F", "G", null);

        graph.addEdge("B", "C", null);
        graph.addEdge("C", "B", null);

        graph.addEdge("B", "I", null);
        graph.addEdge("I", "B", null);

        graph.addEdge("F", "E", null);
        graph.addEdge("E", "F", null);

        graph.addEdge("C", "D", null);
        graph.addEdge("D", "C", null);

        graph.addEdge("I", "D", null);
        graph.addEdge("D", "I", null);

        graph.addEdge("G", "D", null);
        graph.addEdge("D", "G", null);

        graph.addEdge("F", "E", null);
        graph.addEdge("E", "F", null);

        graph.addEdge("G", "H", null);
        graph.addEdge("H", "G", null);

        graph.addEdge("D", "H", null);
        graph.addEdge("H", "D", null);

        graph.addEdge("E", "H", null);
        graph.addEdge("H", "E", null);

        graph.bfs("A");

        // A B F C I G E D H
    }
}
