package org.jsjeong.algorithm.routing.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비 우선 탐색
 *
 * 인접 행렬 방식
 *
 *
 */
public class BreadthFirstSearch_2 {

    private static final int[] dx = {-1, 0, 1, 0};//방향 벡터
    private static final int[] dy = {0, 1, 0, -1};//방향 벡터
    private int n, m = 0; //최대 x, y 좌표
    private final Queue<Node> queue = new LinkedList<>();
    private int[][] map;
    private boolean[][] visited; //방문 여부 체크
    private int[][] dis;

    public BreadthFirstSearch_2(int[][] map){
        this.map = map;
        this.n = map.length;
        this.m = map[0].length;

        this.visited = new boolean[n][m];
        this.dis = new int[n][m];
    }

    public void initialize(int start_x, int start_y){
        visited[start_x][start_y] = true;
        queue.offer(new Node(start_x, start_y));

    }

    public void bfs(int start_x, int start_y) {
        initialize(start_x, start_y);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            for (int i = 0; i < 4; i++) { // 위, 아래, 왼쪽, 오른쪽 4방향 인접 노드 탐색
                int nx = tmp.x + dx[i]; //인접 노드 x 값
                int ny = tmp.y + dy[i]; //인접 노드 y 값

                if (nx < 0|| nx >= n || ny < 0 || ny >= m) { //유효 범위 이탈 방지
                    continue;
                }

                if(map[nx][ny] == 1){ // 1(벽)일 경우 패스
                    continue;
                }

                //이미 방문된 경우 스킵
                if (visited[nx][ny]) {
                    continue;
                }else{
                    visited[nx][ny] = true; //방문하지 않은 경우 방문 체크
                }

                dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                queue.offer(new Node(nx, ny)); //방문할 인접 노드의 인접 노드 추가

            }
        }
        print();
    }

    public void bfs(int start_x, int start_y, int end_x, int end_y) {

        initialize(start_x, start_y);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            for (int i = 0; i < 4; i++) { //인접 노드 탐색
                int nx = tmp.x + dx[i]; //인접 노드 x 값
                int ny = tmp.y + dy[i]; //인접 노드 y 값

                if (nx < 0|| nx >= n || ny < 0 || ny >= m) { //유효 범위 이탈 방지
                    continue;
                }

                if(map[nx][ny] == 1){ // 1(벽)일 경우 패스
                    continue;
                }

                if(nx == end_x && ny == end_y){ //목적지 도착한 경우 종료
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    print();
                    return;
                }

                //이미 방문된 경우 스킵
                if (visited[nx][ny]) {
                    continue;
                }else{
                    visited[nx][ny] = true; //방문하지 않은 경우 방문 체크
                }

                //방문하지 않은 경우
                dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                queue.offer(new Node(nx, ny));

            }
        }

    }

    public void print(){
        for(int[] row: dis){
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static class Node implements Comparable<Node> {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[][]{{0, 0, 0, 0, 0}
                                , {0, 0, 1, 1, 0}
                                , {0, 0, 1, 0, 0}
                                , {0, 0, 1, 0, 0}
                                , {1, 0, 0, 0, 0}};

        BreadthFirstSearch_2 bfs = new BreadthFirstSearch_2(map);
        bfs.bfs(1, 1, 1, 4);
        bfs.bfs(1, 1);
    }

}
