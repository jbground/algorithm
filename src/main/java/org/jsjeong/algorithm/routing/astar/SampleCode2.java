package org.jsjeong.algorithm.routing.astar;

import java.util.*;

public class SampleCode2 {

    private static final int[][] coordinate = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //{-1, -1}, {-1, 1}, {1, -1}, {1, 1}

    private int n, m = 0; //최대 x, y 좌표
    private final char[][] map;

    private final List<Node> open_list = new ArrayList<>();
    private final List<Node> closed_list = new ArrayList<>();

    public SampleCode2(char[][] map){
        this.map = map;
        this.n = map.length;
        this.m = map[0].length;
    }

    public void astar(int start_x, int start_y, int end_x, int end_y){

        Node start_node = new Node(start_x, start_y);
        start_node.setHeuristics(0, 0);

        open_list.add(start_node);

        while (!open_list.isEmpty()) {

            // Get the current node, Priority Queue 로 대체 가능
            Node current_node = open_list.get(0);
            int current_index = 0;

            for (int i = 0; i < open_list.size(); i++) {
                if (open_list.get(i).F < current_node.F) {
                    current_node = open_list.get(i);
                    current_index = i;
                }
            }

            // Pop current off open list, add to closed list
            open_list.remove(current_index);
            closed_list.add(current_node);

            // 목적지에 도착했을 때
            if(current_node.x == end_x && current_node.y == end_y){
                Node current = current_node;
                while(current != null){
                    if(map[current.x][current.y] == '0'){
                        map[current.x][current.y] = '*';
                        current = current.parent;
                    }
                }
                print();
                return;
            }

            List<Node> children = new ArrayList<>();
            //********인접 정점 수집 영역*************/
            for (int[] new_position : coordinate) {
                int[] node_position = {current_node.x + new_position[0], current_node.y + new_position[1]};

                //유효 범위를 이탈했으면 스킵
                if (node_position[0] < 0|| node_position[0] >= n || node_position[1] < 0 || node_position[1] >= m) {
                    continue;
                }

                //진행 불가능한 구역이면 스킵
                if(map[node_position[0]][node_position[1]] == '1'){
                    continue;
                }

                Node new_node = new Node(current_node, node_position);
                children.add(new_node);

                for(Node child : children){

                    // Child is on the closed list
                    for(Node c2 : closed_list){
                        if(child.x == c2.x && child.y == c2.y){
                            continue;
                        }
                    }

                    // Create the f, g, and h values
                    child.G = current_node.G + 1;
                    child.H = (int) (Math.pow(child.x - end_x, 2) + Math.pow(child.y - end_y, 2));
                    child.F = child.G + child.H;

                    for(Node node : open_list){
                        if(child.equals(node) && child.G > node.G){
                            continue;
                        }
                    }

                    open_list.add(child);

                }
            }
        }
    }

    public void print(){
        for(char[] row: map){
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static class Node implements Comparable<Node> {

        private Node parent;
        private int x;
        private int y;

        private int G;
        private int H;
        private int F;

        public Node(Node parent, int[] coord) {
            this.parent = parent;
            this.x = coord[0];
            this.y = coord[1];
        }

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

        SampleCode2 sample = new SampleCode2(map);
        sample.astar(1, 1, 5, 8);
    }
}
