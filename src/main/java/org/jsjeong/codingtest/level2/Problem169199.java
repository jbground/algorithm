package org.jsjeong.codingtest.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */
public class Problem169199 {

    static final int[][] coordinate = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //up down left right
    static int[][] matrix;
    static int[][] v;

    static int n, m;// n = 열, m = 행
    static int startX, startY;
    static int endX, endY;
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        matrix = new int[n][m];
        v = new int[n][m];

        //initialize
        for (int i = 0; i < board.length; i++) {
            char[] arr = board[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == 'D'){
                    matrix[i][j] = -1;
                } else if (arr[j] == 'R') {
                    startX = i;
                    startY = j;
                } else if (arr[j] == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        while(!queue.isEmpty()){
            int[] now = queue.poll();

            int x = now[0];
            int y = now[1];
            for(int i = 0 ; i< 4; i++){//4방향 이동
                int dx = x + coordinate[i][0];
                int dy = y + coordinate[i][1];

                if(dx < 0 || dx >= n || dy < 0 || dy >= m || matrix[dx][dy] == 1){
                    continue;
                }

                int nx = x;
                int ny = y;
                while (true){//미끄러지기 구현
                    nx += coordinate[i][0];
                    ny += coordinate[i][1];

                    //맨 끝이나 장애물 부딪힐 때 까지
                    if(nx == 0 || nx >= n || ny < 0 || ny >= m || matrix[dx][dy] == 1){
                        nx -= coordinate[i][0];
                        ny -= coordinate[i][1];

                        v[nx][ny] += 1;

                        if(v[nx][ny] > v[x][y] + 1){
                            queue.add(new int[]{nx, ny});
                            v[nx][ny] = v[x][y] + 1;
                        }

                        break;
                    }
                }
            }

        }



        return answer;
    }

}
