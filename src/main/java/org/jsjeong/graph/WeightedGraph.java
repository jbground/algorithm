package org.jsjeong.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 가중 그래프
 */
public class WeightedGraph {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int[] weight = {2, 4, 4, 6, 5, 1, 3, 6, 9, 2};
        int n = 7;

        WeightedGraph o = new WeightedGraph();
//        o.adjacencyList2(n, edges, weight);
        o.adjacencyList(n, edges, weight);
    }

    /**
     * 양방향 가중치 인접 행렬
     */
    public void adjacencyMatrix(int n, int[][] edges, int[] weight){

        int[][] matrix = new int[n + 1][n + 1];
//        for(int i = 0 ; i<matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                matrix[i][j] = -1;
//            }
//        }


        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            matrix[edge[0]][edge[1]] = weight[i];
            matrix[edge[1]][edge[0]] = weight[i];
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }

    /**
     *  단방향 가중치 인접 행렬
     */
    public void adjacencyMatrix2(int n, int[][] edges, int[] weight){

        int[][] matrix = new int[n + 1][n + 1];
//        for(int i = 0 ; i<matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                matrix[i][j] = -1;
//            }
//        }


        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            matrix[edge[0]][edge[1]] = weight[i];
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * 양방향 가중치 인접 리스트
     */
    public void adjacencyList(int n, int[][] edges, int[] weight){
        LinkedList<Edge> edgeList = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            Edge e = new Edge(i);
            edgeList.add(e);
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            Edge e1 = edgeList.get(edge[0]);
            Edge e2 = edgeList.get(edge[1]);

            if (!e1.adjacent.contains(e2)) {
                e1.adjacent.add(e2);
                e1.weight.add(weight[i]);
            }
            if(!e2.adjacent.contains(e1)){
                e2.adjacent.add(e1);
                e2.weight.add(weight[i]);
            }
        }

        for(Edge e : edgeList){
            System.out.print(e.toString() + " ");
            System.out.println();
        }


    }

    class Edge{
        int key;
        LinkedList<Edge> adjacent;
        LinkedList<Integer> weight;
        public Edge(int key){
            this.key = key;
            adjacent = new LinkedList<>();
            weight = new LinkedList<>();
        }
    }

    /**
     * 단방향 가중치 인접 리스트
     */
    public void adjacencyList2(int n, int[][] edges, int[] weight){

        LinkedList<Node> nodes = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            Node nd = new Node(i);
            nodes.add(nd);
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Node n1 = nodes.get(edge[0]);
            Node n2 = nodes.get(edge[1]);

            if (!n1.adjacent.containsKey(n2)) {
                n1.adjacent.put(n2, weight[i]);
            }

        }

        for(Node nd : nodes){
            System.out.print(nd.toString() + " ");
            System.out.println();
        }

    }

    class Node{
        int key;
        HashMap<Node, Integer> adjacent;
        boolean visited;

        Node(int data) {
            this.key = data;
            this.adjacent = new HashMap<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}
