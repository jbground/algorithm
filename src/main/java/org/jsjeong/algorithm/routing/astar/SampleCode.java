package org.jsjeong.algorithm.routing.astar;


import java.util.*;

public class SampleCode {

    private static final int[] dx = {-1, 0, 1, 0};//방향 벡터
    private static final int[] dy = {0, 1, 0, -1};//방향 벡터
    private int n, m = 0; //최대 x, y 좌표
    private final Queue<Node> queue = new PriorityQueue<>();
    private char[][] map;
    private boolean[][] visited; //방문 여부 체크
    private Map<Integer, Node> path = new HashMap<>();

    private int[][] open;

    public SampleCode(char[][] map){
        this.map = map;
        this.n = map.length;
        this.m = map[0].length;
        this.visited = new boolean[n][m];
        this.open = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                open[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void astar(int start_x, int start_y, int end_x, int end_y){

        //initialize
        map[start_x][start_y] = 's';
        map[end_x][end_y] = 'e';

        Node start = new Node(start_x, start_y);
        start.setHeuristics(0, 0);

        queue.offer(start);

        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            //********정점 탐색 영역*************/
            if (tmp.x == end_x && tmp.y == end_y) { //목적지에 도착했을 경우 종료
                break;
            }

           //정점 방문
            visited[tmp.x][tmp.y] = true;


            //********인접 정점 수집 영역*************/
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                //유효 범위를 이탈했으면 스킵
                if (nx < 0|| nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                //진행 불가능한 구역이면 스킵
                if(map[nx][ny] == '1'){
                    continue;
                }

                if(visited[nx][ny]){ //이미 방문한 정점이면 패스
                    continue;
                }

                //비용 계산
                int g = tmp.G + 1;
                int h = Math.abs(end_x - nx) + Math.abs(end_y - ny); //휴리스틱 값을 만드는 로직에 따라 A*의 성능이 달라짐
                int f = g + h;

                if(open[nx][ny] < g + h){
                    continue;
                }

                open[nx][ny] = g+h;

                //다른 경로에서 더 빠른 길을 이미 찾았으면 스킵
                Node node = new Node(nx, ny);
                node.setHeuristics(g, h);


//                if(path.get(tmp.G) != null){
//                    Node node1 = path.get(tmp.G);
//                    if(node1.F > f){
//                        path.put(tmp.G, node);
//                    }
//                }else{
//                    path.put(tmp.G, node);
//                }

                queue.add(node);
            }
        }

        print();
    }

    public void print(){
        for(Node node : path.values()){
            if(node != null){
                map[node.x][node.y] = '*';
            }

        }

        for(char[] row: map){
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }


    static class Node implements Comparable<Node> {
        private int x;
        private int y;

        private int G;
        private int H;
        private int F;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setHeuristics(int G, int H){
            this.G = G;
            this.H = H;
            this.F = G+H;
        }


        @Override
        public int compareTo(Node o) {
            if(F == o.F){
                return H > o.H ? 1 : -1;
            }else{
                return F > o.F ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        char[][] map =   {{'0', '0', '1', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', '1', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', '1', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', '1', '0', '0', '1', '1', '1', '1', '1'}
                        , {'0', '0', '1', '0', '0', '1', '0', '0', '0', '0'}
                        , {'0', '0', '1', '0', '0', '0', '0', '1', '0', '0'}
                        , {'0', '0', '1', '0', '0', '0', '0', '1', '0', '0'}
                        , {'0', '0', '0', '0', '1', '0', '0', '1', '0', '0'}
                        , {'0', '0', '0', '0', '1', '0', '0', '0', '0', '0'}
                        , {'0', '0', '0', '0', '1', '0', '0', '0', '0', '0'}};

        int[][] map2 = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
                     , {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
                     , {0, 0, 1, 0, 0, 1, 1, 1, 1, 1}
                     , {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
                     , {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
                     , {0, 0, 1, 0, 0, 1, 0, 0, 0, 0}
                     , {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
                     , {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
                     , {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
                     , {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};

        SampleCode sample = new SampleCode(map);
        sample.astar(1, 1, 8, 8);

    }
}
