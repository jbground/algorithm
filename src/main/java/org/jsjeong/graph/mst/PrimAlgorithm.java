package org.jsjeong.graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 그리디(Greedy) 알고리즘 의 한 종류
 *
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int[] weight = {2, 4, 4, 6, 5, 1, 3, 6, 9, 2, 1};
        int n = 7;
        int m = 11;

        PrimAlgorithm o = new PrimAlgorithm();
        System.out.println(o.process1(n, m, edges, weight));
        o.process2();

    }

    /**
     * O(V^2)
     *
     */
    public int process1(int n, int m, int[][] edges, int[] weight){

        ArrayList[] graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new Node(edge[1], weight[1]));
            graph[edge[1]].add(new Node(edge[0], weight[1]));
        }

        //prim algorithm
        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 0)); //start

        int total = 0;
        while (!q.isEmpty()){
            Node node = q.poll();
            int v = node.adjacent;
            int cost = node.cost;

            if(visit[v])
                continue;

            visit[v] = true;
            total += cost;

            for (Object o : graph[v]){
                Node nd = (Node) o;
                if(!visit[nd.adjacent]){
                    q.add(nd);
                }
            }

        }
        return total;
    }

    class Node implements Comparable<Node>{
        int adjacent;
        int cost;

        Node(int adjacent, int cost) {
            this.adjacent = adjacent;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    /**
     * O(E log V)
     */
    public void process2(){

    }
}
