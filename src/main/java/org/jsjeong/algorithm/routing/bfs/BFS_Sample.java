package org.jsjeong.algorithm.routing.bfs;

import java.util.PriorityQueue;

public class BFS_Sample {

    static int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n, m;
    static char[][] miro;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        miro = new char[n][m];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                miro[i][j] = maps[i].charAt(j);
                switch (miro[i][j]){
                    case 'S':
                        start[0] = i;
                        start[1] = j;
                        break;
                    case 'L':
                        lever[0] = i;
                        lever[1] = j;
                        break;
                    case 'E':
                        end[0] = i;
                        end[1] = j;
                        break;
                }
            }
        }

        int sTol = bfs(start, lever);
        if(sTol <= 0)
            return -1;
        int lToe = bfs(lever, end);
        if(lToe <= 0)
            return -1;

        return sTol + lToe;

    }

    public int bfs(int[] start, int[] end){

        PriorityQueue<Pos> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Pos(start[0], start[1], 0));

        while (!queue.isEmpty()){
            Pos pos = queue.poll();

            //종료지점 설정
            if(end[0] == pos.x && end[1] == pos.y)
                return pos.dis;

            for (int[] ints : dxy) { //4 방향 좌표
                int nx = pos.x + ints[0];
                int ny = pos.y + ints[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || miro[nx][ny] == 'X')
                    continue;

                if (visited[nx][ny])
                    continue;

                queue.offer(new Pos(nx, ny, pos.dis + 1));
                visited[nx][ny] = true;
            }
        }
        return 0;
    }

    static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int dis;

        public Pos(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pos o) {
            return this.dis - o.dis;
        }
    }
}
