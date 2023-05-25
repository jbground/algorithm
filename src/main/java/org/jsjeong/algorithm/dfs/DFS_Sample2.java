package org.jsjeong.algorithm.dfs;

import java.util.Scanner;

/**
 * 그래프에서의 깊이 우선 경로 탐색
 */
public class DFS_Sample2 {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v){
        if(v == n){
            answer++;
        }else{
            for (int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS_Sample2 dfs_sample2 = new DFS_Sample2();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n+1][m+1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        dfs_sample2.DFS(1);
        System.out.println(answer);

    }
}
