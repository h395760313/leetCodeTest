package com.algorithm.structure._12_图;

public interface Graph<V, E> {
    int edgesSize();

    int verticesSize();

    void addVertex(V v);

    void addEdge(V from, V to);

    void addEdge(V from, V to, E weight);

    void removeVertex(V v);

    void removeEdge(V from, V to);

    void print();

    void bfs(V begin);
}
