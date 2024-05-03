package org.jsjeong.graph;

import java.util.ArrayList;

/**
 * 무방향(양방향) 그래프
 *  1. 인접 행렬을 이용한 구현
 *      2차원 배열 이용
 *      matrix[v][w] = 1 정점 v에서 정점 w로 가는 간선이 있음
 *      matirx[v][w] = 0 정점 v에서 정점 w로 가는 간선이 없음
 *
 *      연결된 정점 찾기 빠름, 구현 쉬움
 *      O(n^2)의 공간 복잡도 가짐
 *
 *  2. 인접 리스트를 이용한 구현
 *      정점의 개수만큼 헤드 노드가 있고 각 정점에 인접한 정점들 리스트로 연결
 *      정점에서 인접 정점들이 연결되어 있음
 *
 *      필요한 만큼 공간 사용하기 때문에 공간 낭비 적음
 *      인접 행렬보다 구현이 어려움
 */
public class UndirectedGraph {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int n = 7;

        UndirectedGraph o = new UndirectedGraph();
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
            matrix[edge[1]][edge[0]] = 1;
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
            list.get(edge[1]).add(edge[0]);
        }

        //출력
        for (int i = 1; i < list.size(); i++) {
            for(int j = 0 ; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j)+" ");
            System.out.println();
        }
    }
}
