package org.jsjeong.algorithm.johnson;

import java.util.ArrayList;
import java.util.List;

public class SampleCode {

    private char[][] map;
    private int n, m = 0; //최대 x, y 좌표

    public SampleCode(char[][] map){
        this.map = map;
        this.n = map.length;
        this.m = map[0].length;
    }


    public void johnson(int start_x, int start_y, int end_x, int end_y){

        //노드 s 를 생성한 후 노드 s로부터 모든 노드들에 대한 가중치를 벨만포드 알고리즘으로 수집
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if(map[i][j] != '1'){
                    List<Node> h = new ArrayList<>();
                    h.add(new Node(i, j));
                }

            }
        }
    }

    public void Dijkstra_Algorithm(){


    }


    static class Node {

        private Node parent;
        private int x;
        private int y;


        public Node(Node parent, int[] coord) {
            this.parent = parent;
            this.x = coord[0];
            this.y = coord[1];
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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

        SampleCode sample = new SampleCode(map);
        sample.johnson(1, 1, 8, 8);
    }

}
