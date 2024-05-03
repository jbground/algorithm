package org.jsjeong.graph;

import java.util.ArrayList;

/**
 * 방향 그래프
 */
public class DirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int n = 7;

        DirectedGraph o = new DirectedGraph();
        o.adjacencyMatrix(n, edges);
        o.adjacencyList(n, edges);
    }

    /**
     * 인접 행렬을 이용한 구현
     */
    public void adjacencyMatrix(int n, int[][] edges){
        int[][] matrix = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 인접 리스트를 이용한 구현
     */
    public void adjacencyList(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());

        for(int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
        }

        //출력
        for (int i = 1; i < list.size(); i++) {
            for(int j = 0 ; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
