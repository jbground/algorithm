package org.jsjeong.algorithm.routing.astar;


import java.util.*;

/**
 * 에이스타 알고리즘
 *  f(n) = g(n) + h(n)
 *  최단거리 길 찾기 알고리즘
 *  다익스트라의 확장판, BFS의 가지치기 알고리즘
 *
 *  1. 최소가 되는 지점을 우선 탐색(우선 순위 큐)
 *  2. 휴리스틱 추정 값 사용
 *  3. Open List / Closed List 이용하여 노드 관리
 *
 *  BFS (Breadth First Search) : 완전 탐색 알고리즘. 우선순위없이 모든 노드를 탐색한다.
 *
 * 다익스트라 : 일반적인 최단거리 알고리즘. 한 노드를 기준으로 모든 노드의 최단 경로를 찾기 때문에 시간 비용이 많이 든다.
 *
 * 플로이드 : 모든 노드의 최단 경로를 찾는 알고리즘. 일반적인 시간 복잡도 O(N^3).
 *
 * 거리 측정 법 맨해튼 거리 측정법 또는 유클리디안 거리 측정법 사용
 */
public class AStart {


    static final int[] dx = {-1, 0, 1, 0};//방향 벡터
    static final int[] dy = {0, 1, 0, -1};//방향 벡터
    static final int[] cost = {1, 1, 1, 1};//방향 별 코스트

    /*
    F = G + H
    F = 최종 점수(작을 수록 좋음, 경로에 따라 달라짐)
    G = 시작점에서 해당 좌표까지 이동하는데 드는 비용(작을 수록 좋음, 경로에 따라 달라짐)
    H = 목적지로부터 얼마나 가까운 곳인지를 따지는 보너스 점수(작을 수록 좋음, 고정인 값)

    */

    boolean[][] visited; //이미 방문했는지 방문 여부 확인

    //출발지에서 (x, y) 가는데에 현재까지 업데이트된 최단거리
    // (x, y)로 가는 길을 한번이라도 발견 했었는지 여부가 될 수도 있다.
    // 발견이 안됐다면 Max값으로 저장되어 있을 것.
    //F = G + H 값이 저장된다. (이 F 값이 가장 작은 정점이 방문 정점으로 선택될 것)
    int[][] open;

    //우선순위 큐 : 예약된 것들 중 가장 좋은 후보를 빠르게 뽑아오기 위한 도구
    Queue<Point> queue = new PriorityQueue<>();
    List<Point> routeList;

    static int n,m;
    public void initialize(char[][] map) {
        n = map.length;
        m = map[0].length;

        //방문경로 초기화
        visited = new boolean[n][m];

        //경로별 점수 초기화
        open = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                open[i][j] = Integer.MAX_VALUE;
            }
        }

        Point start = null;
        Point end = null;

        //시작지점과 종료지점 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = map[i][j];

                if(c == 'S'){
                    start = new Point(i, j, 0, 0, 0);
                    queue.add(start);
                }else if(c == 'E'){
                    end = new Point(i, j, 0, 0, 0);
                } else if (c == '1') {
                    
                }
            }

        }

        a_star(map, start, end);
    }

    public void a_star(char[][] map, Point start, Point end) {

        //큐가 비거나 목적 지점에 도착할 때까지 반복
        while(!queue.isEmpty()){
            Point tmp = queue.poll(); //제일 좋은 후보 뽑기

            if(visited[tmp.x][tmp.y]){ //동일한 좌표를 여러 경로로 찾아서, 더 빠른 경로로 인해서 이미 방문된 경우 스킵
                continue;
            }

            //해당 경로 방문
            visited[tmp.x][tmp.y] = true;

            //목적지에 도착했으면 바로 종료
            if (tmp.x == end.x && tmp.y == end.y) {
                break;
            }

            //4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){ //유효 범위 이탈 방지
                    continue;
                }

                //진행 불가능한 구역이면 스킵
                if(map[nx][ny] == '0'){
                    continue;
                }

                //이미 방문된 경우 스킵
                if(visited[tmp.x][tmp.y]){
                    continue;
                }

                //비용 계산

                int g = tmp.G + cost[i];
                int h = Math.abs(end.x - nx) + Math.abs(end.y - ny);

                //다른 경로에서 더 빠른 길을 이미 찾았으면 스킵
                if(open[nx][ny] < g + h){
                    continue;
                }

                open[nx][ny] = g+h;
                queue.add(new Point(nx, ny, 0, g, h));
            }


        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int p_index;

        int G; //시작지점으로부터 온 거리
        int H; //목적지까지의 거리
        int F; //기대 거리

        public Point(int x, int y, int p_index, int G, int H){
            this.x = x;
            this.y = y;
            this.p_index = p_index;
            this.G = G;
            this.H = H;
            this.F = G+H;
        }

        @Override
        public int compareTo(Point o) {
            if(F == o.F){
                return 0;
            }else{
                return F < o.F ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        char[][] map = {
                {'E', '0', '1', '1', '1', '1'}
                , {'1', '0', '1', '1', '1', '1'}
                , {'0', '1', '0', '0', '0', '1'}
                , {'1', '1', '0', '0', 'S', '1'}
                , {'1', '1', '1', '1', '1', '1'}
                , {'1', '1', '0', '0', '1', '1'}
                , {'1', '1', '1', '1', '1', '1'}};

        AStart a = new AStart();
        a.initialize(map);

    }
}
