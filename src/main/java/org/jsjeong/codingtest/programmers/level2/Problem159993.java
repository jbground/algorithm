package org.jsjeong.codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탈출
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * BFS 적용
 */
public class Problem159993 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n,m;

    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();

        Point start = null;
        Point waypoint = null;
        Point end = null;

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j];

                if(chars[j] == 'S'){
                    start = new Point(i, j);
                }else if (chars[j] == 'L'){
                    waypoint = new Point(i, j);
                } else if (chars[j] == 'E') {
                    end = new Point(i, j);
                }
            }
        }

        int startToWayPoint = bfs(arr, start, waypoint);


        if(startToWayPoint != -1){
            int leverToExit = bfs(arr, waypoint, end);

            if(leverToExit != -1){
                answer = startToWayPoint + leverToExit;
            }
        }

        return answer;
    }

    public int bfs(char[][] arr, Point start, Point dest){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            if(arr[tmp.x][tmp.y] == arr[dest.x][dest.y]){ //목적지 도착
                return tmp.depth;
            }

            for (int i = 0; i < 4; i++) { //4방향
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){ //배열 범위 이탈 방지
                    if(!visited[nx][ny] && arr[nx][ny] != 'X'){ //O만 설정할 경우 목적지 L 일때 등록 안함
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, tmp.depth+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Point{
        int x;
        int y;

        int depth;

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.depth = 0;
        }

        Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}
