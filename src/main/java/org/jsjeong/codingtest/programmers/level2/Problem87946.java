package org.jsjeong.codingtest.programmers.level2;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class Problem87946 {

    public static boolean check[];
    public static int ans = 0;

    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    /**
     * dfs 완전 탐색
     */
//    public void dfs(int tired, int[][] dungeons, int cnt) {
//        for (int i = 0; i < dungeons.length; i++) {
//
//            if (!check[i] && dungeons[i][0] <= tired) {
//                check[i] = true;
//                dfs(tired - dungeons[i][1], dungeons, cnt + 1);
//                check[i] = false;
//            }
//        }
//        ans = Math.max(ans, cnt);
//    }

    int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d : dungeons) {
            int a = d[0], b = d[1];

            if(a <= k) {
                d[0] = 9999;
                cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                d[0] = a;
            }
        }
        return cnt;
    }
}
