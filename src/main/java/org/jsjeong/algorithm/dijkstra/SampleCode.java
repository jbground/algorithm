package org.jsjeong.algorithm.dijkstra;

import java.util.LinkedList;
import java.util.Queue;

public class SampleCode {

    private static final int[][] coordinate = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //{-1, -1}, {-1, 1}, {1, -1}, {1, 1}

    private final char[][] map;

    private int n, m = 0; //최대 x, y 좌표

    private Queue<Node> queue = new LinkedList<>();

    public SampleCode(char[][] map) {
        this.map = map;
        this.n = map.length;
        this.m = map[0].length;
    }

    public void dijkstra() {

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            //********인접 정점 수집 영역*************/
            for (int[] new_position : coordinate) {
                int tmp_x = current.x + new_position[0];
                int tmp_y = current.y + new_position[1];

                if (tmp_x < 0|| tmp_x >= n || tmp_y < 0 || tmp_y >= m) {
                    continue;
                }

                //진행 불가능한 구역이면 스킵
                if(map[tmp_x][tmp_y] == '1'){
                    continue;
                }


            }
        }


    }


    static class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public static void main(String[] args) {
        char[][] map =   {{'0', '0', 'w', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', 'w', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', 'w', '0', '0', '0', '0', '0', '0', '0'}
                        , {'0', '0', 'w', '0', '0', 'w', 'w', 'w', 'w', 'w'}
                        , {'0', '0', 'w', '0', '0', 'w', '0', '0', '0', '0'}
                        , {'0', '0', 'w', '0', '0', '0', '0', 'w', '0', '0'}
                        , {'0', '0', 'w', '0', '0', '0', '0', 'w', '0', '0'}
                        , {'0', '0', '0', '0', 'w', '0', '0', 'w', '0', '0'}
                        , {'0', '0', '0', '0', 'w', '0', '0', '0', '0', '0'}
                        , {'0', '0', '0', '0', 'w', '0', '0', '0', '0', '0'}};

        SampleCode sample = new SampleCode(map);
        sample.dijkstra();
    }



}
