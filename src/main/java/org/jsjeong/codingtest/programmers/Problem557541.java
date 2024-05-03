package org.jsjeong.codingtest.programmers;

import java.util.*;

public class Problem557541 {

    int[] _dx = {0, -1, 0, 1};
    int[] _dy = {1, 0, -1, 0};
    int n;
    int m;
    boolean[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        List<String> cate = new ArrayList<>();
        Problem557541 o = new Problem557541();
        System.out.println(o.solution(maps));

        Map<String, Integer> ca = new HashMap<>();
        ca.containsKey(null);

        Integer i = ca.get("");

    }


    public int solution(int[][] maps) {

        //initialize
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m]; //방문 여부 확인

        int run = run(maps);


        return run;

    }

    public int run(int[][] maps) {

        //initialize
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        //start
        while (!queue.isEmpty()) {

            int[] node = queue.poll();

            if (visited[node[0]][node[1]])
                continue;
            else{
                visited[node[0]][node[1]] = true;
            }

            if (node[0] == n - 1 && node[1] == m - 1) { //목적지 도착
                return maps[node[0]][node[1]];
            }

            for (int i = 0; i < 4; i++) { //이동 가능 방향 탐색
                int dx = _dx[i] + node[0];
                int dy = _dy[i] + node[1];

                if (dx < 0 || dx >= n || dy < 0 || dy >= m) //배열 범위 초과
                    continue;

                if (maps[dx][dy] == 0) // 이동 불가 영역
                    continue;

                if (visited[dx][dy]) //이미 방문한 지점
                    continue;

                //다음 이동 추가
                maps[dx][dy] += maps[node[0]][node[1]];
                queue.add(new int[]{dx, dy});

            }
        }
        return -1;

    }

    class Node implements Comparable{
        int x;
        int y;
        int cost;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
