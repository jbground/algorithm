package org.jsjeong.codingtest.programmers.level3;

import java.util.ArrayList;

public class Problem557492 {
    public static void main(String[] args) {
        Problem557492 problem = new Problem557492();
        int n = 10;
        int m = 10;
        int[][] edge_list = {{1,2}, {1,3}, {2,3}, {2,4}, {3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}};
        int k = 6;
        int[] gps_log = {1, 2, 3, 3, 6, 7};
        System.out.println(problem.solution(n, m, edge_list, k, gps_log));
    }

    private int solution(int n, int m, int[][] edgeList, int k, int[] gpsLog) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] edge : edgeList){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < k; i++) {
            int log = gpsLog[i];

            ArrayList<Integer> integers = list.get(log);


        }



        return answer;
    }

}
