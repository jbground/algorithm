package org.jsjeong.algorithm.dijkstra;

import java.util.*;

public class SampleCode {

    private static final int[][] coordinate = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //{-1, -1}, {-1, 1}, {1, -1}, {1, 1}



    public SampleCode() {
    }

    public void dijkstra(Node start, int count) {
        //initialize
        int[] dist = new int[count];
        for(int i= 0; i< count; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        List<Node> open_list = new ArrayList<>();
        open_list.add(start);

        while (!open_list.isEmpty()) {

            Node current_node = open_list.get(0);
            open_list.remove(0);
            //가장 짧은 거리에 있는 노드부터 순회(PriorityQueue로 대체 가능)
//            int current_index = 0;
//            for (int i = 0; i < open_list.size(); i++) {
//
//                if(open_list.get(i).cost <= current_node.cost){
//                    current_node = open_list.get(i);
//                    current_index = i;
//                }
//            }
//            open_list.remove(current_index);

            if(dist[current_node.vex] < current_node.cost){
                continue;
            }


            //********인접 정점 수집 영역*************/
            for (Iterator<Node> it = start.getIterator(); it.hasNext(); ) {
                Node next = it.next();
                next.cost = (int) (Math.pow(start.x - next.x, 2) + Math.pow(start.y - next.y, 2));
                int next_cost = next.cost;

                if(dist[next.vex] > next_cost){
                    dist[next.vex] = next_cost;
                    open_list.add(next);
                }
            }
        }

        //출력
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }


    static class Node {
        private String name; //node 이름
        private int vex;
        private int x;
        private int y;

        private int cost;

        private final Set<Node> children = new HashSet<>(); //이동 가능 노드

        public Node(String name) {
            this.name = name;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(String name, int vex, int x, int y) {
            this.name = name;
            this.vex = vex;
            this.x = x;
            this.y = y;
        }

        public void addChildren(Node node){
            children.add(node);

        }

        public Iterator<Node> getIterator(){
            return children.iterator();
        }

    }


    public static void main(String[] args) {

        Node node0 = new Node("Machine", 0, 12, 23);

        Node node1 = new Node("V001", 1, 15, 45);
        Node node2 = new Node("V002", 2, 5, 65);
        Node node3 = new Node("V003", 3, 43, 39);
        Node node4 = new Node("V004", 4, 21, 12);
        Node node5 = new Node("V005", 5, 14, 2);
        Node node6 = new Node("V006", 6, 32, 12);
        Node node7 = new Node("V007", 7, 34, 54);

        node0.addChildren(node1);
        node0.addChildren(node2);
        node0.addChildren(node3);
        node0.addChildren(node4);
        node0.addChildren(node5);
        node0.addChildren(node6);
        node0.addChildren(node7);
//        v = (int) (Math.pow(machine_x - vehicle_x, 2) + Math.pow(machine_y - vehicle_y, 2));


        SampleCode sample = new SampleCode();
        sample.dijkstra(node0, 8);
    }


}
