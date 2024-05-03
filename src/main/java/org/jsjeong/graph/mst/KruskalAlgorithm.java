package org.jsjeong.graph.mst;

public class KruskalAlgorithm {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int[] weight = {2, 4, 4, 6, 5, 1, 3, 6, 9, 2, 1};
        int n = 7;
        int m = 11;

        KruskalAlgorithm o = new KruskalAlgorithm();
        System.out.println(o.process1(n, m, edges, weight));

    }

    private int process1(int n, int m, int[][] edges, int[] weight) {


        return -0;
    }
}
