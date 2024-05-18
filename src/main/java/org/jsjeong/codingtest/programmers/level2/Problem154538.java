package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 숫자 변환하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
public class Problem154538 {
//    public int solution(int x, int y, int n) {
//
//        Queue<Cul> queue = new LinkedList<>();
//        queue.add(new Cul(x, 0));
//        boolean[] check = new boolean[y-x + 1];
//        check[0] = true;
//        while (!queue.isEmpty()) {
//
//            Cul cul = queue.poll();
//
//            if (cul.x == y)
//                return cul.cost;
//
//            int next;
//            next = cul.x * 2;
//            if (next <= y && !check[next - x]) {
//                queue.add(new Cul(next, cul.cost + 1));
//                check[next - x] = true;
//            }
//            next = cul.x * 3;
//            if (next <= y && !check[next - x]) {
//                queue.add(new Cul(next, cul.cost + 1));
//                check[next - x] = true;
//            }
//
//            next = cul.x + n;
//            if (next <= y && !check[next - x]) {
//                queue.add(new Cul(next, cul.cost + 1));
//                check[next - x] = true;
//            }
//        }
//
//        return -1;
//    }
//
//    static class Cul {
//        int x;
//        int cost;
//
//        public Cul(int x, int cost) {
//            this.x = x;
//            this.cost = cost;
//        }
//    }


    public int solution(int x, int y, int n) {
        int INF = Integer.MAX_VALUE;
        int[] dp = new int[y + 1];

        Arrays.fill(dp, -1);
        dp[x] = 0;

        for (int i = x + 1; i <= y; i++) {
            int a = INF, b = INF, c = INF;

            if (i - n >= 0 && dp[i - n] != -1)
                a = dp[i - n] + 1;

            if (i % 2 == 0 && dp[i / 2] != -1)
                b = dp[i / 2] + 1;

            if (i % 3 == 0 && dp[i / 3] != -1)
                c = dp[i / 3] + 1;

            if (a == INF && b == INF && c == INF) {
                dp[i] = -1;
                continue;
            }
            dp[i] = Math.min(Math.min(a, b), c);
        }

        return dp[y];
    }
}
