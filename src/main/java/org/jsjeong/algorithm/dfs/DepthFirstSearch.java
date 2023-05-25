package org.jsjeong.algorithm.dfs;

public class DepthFirstSearch {

    boolean[] marked = new boolean[9];

    int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 6}, {1, 2}};

    void dfs(int index) {
        marked[index] = true;
        visit(index);
        for (int node : graph[index]) {
            if (!marked[node]) {
                dfs(node);
            }
        }
    }

    void visit(int index) {
        System.out.print(index + " ");
    }
}
