package org.jsjeong.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 다익스트라 알고리즘
 *  최단 경로 탐색 알고리즘, 인공위성 GPS 소프트웨어 등에서 가장 많이 사용됨
 *  특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려줌. 다만, 이 다음의 간선은 포함할 수 없음
 *  현실 세계 에서는 음의 간선이 존재하지 않기 때문에 현실 세계에 적용하기 매우 적합한 알고리즘 중 하나
 *
 *  다익스트라 방법 1
 *  O(n) x n 만큼 돌면서 경로별 최소 값이 발생할 경우 최소 값으로 대체한다.
 *
 *  다익스트라 방법 2
 *   n x log n 번만 실행
 *   PriorityQueue를 적용하면 됨.
 */
public class Dijkstra {

    int[] dis;

    public static void solution(int[][] arr, int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int[] ints : arr) {
            graph.get(ints[0]).add(new Edge(ints));
        }

        System.out.println(graph);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int v = 1;
        pq.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) {
                continue;
            }

            for (Edge e : graph.get(now)) {
                if(dis[e.vex] > nowCost + e.cost){
                    dis[e.vex] = nowCost + e.cost;
                    pq.offer(new Edge(e.vex, nowCost + e.cost));
                }
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 12}, {1, 3, 4}, {2, 1, 2}, {2, 3, 5}, {2, 5, 5}, {3, 4, 5}, {4, 2, 2}, {4, 5, 5}, {6, 4, 5}};
        solution(arr, 6);

    }

    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        public Edge(int[] arr) {
            this.vex = arr[1];
            this.cost = arr[2];
        }

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
