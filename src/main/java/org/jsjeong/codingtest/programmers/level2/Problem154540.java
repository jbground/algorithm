package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 무인도 여행
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
public class Problem154540 {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 , 0, -1, 1};

    static int[][] matrix;
    static boolean[][] visited;
    static int n, m;
    static int count;

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        matrix = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < maps.length; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'X') {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = Integer.parseInt(String.valueOf(arr[j]));
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] != -1 && !visited[i][j]) { //바다가 아니고 방문한 적 없는 곳
                    count = 0;
                    bfs(i, j);
                    answer.add(count);
                }
            }
        }
        if(answer.isEmpty()){
            return new int[]{-1};
        }

        answer.sort(Comparator.comparingInt(o -> o));
        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    public void bfs(int x, int y){

        count += matrix[x][y];
        visited[x][y] = true;

        for(int k = 0; k <4; k++){ //4 방향 진행
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || matrix[nx][ny] == -1){ //범위 이탈 종료
                continue;
            }

            if(visited[nx][ny]){ //이미 방문 종료
                continue;
            }

            bfs(nx, ny);

        }

    }
}
