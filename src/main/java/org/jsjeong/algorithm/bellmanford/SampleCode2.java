package org.jsjeong.algorithm.bellmanford;

import java.util.*;

/**
 * 그래프 기준으로 벨만포드 알고리즘 실행
 */
public class SampleCode2 {

    private final List<Node> nodeList = new ArrayList<>();

    public void bellman(int s){

        //정점(노드)의 개수
        int v = 9;

        //간선의 개수
        int e = nodeList.size();

        //경로 저장 생성
        int[] distribution = new int[v];

        //모든 정점으로의 거리 무한대 설정
        for (int i = 0; i < v; ++i){
            distribution[i] = Integer.MAX_VALUE;
        }

        //시작 정점 거리 0 설정
        distribution[s] = 0;



        //n(정점 개수) - 1 만큼 간선별 가중치 갱신
        for (int i = 1; i < v; i++) {
            for(int j = 0; j < e; j++){
                Node node = nodeList.get(j);
                int source = node.source;
                int target = node.target;
                int weight = node.weigth;

                if(distribution[source] != Integer.MAX_VALUE){ //MAX_VALUE가 아닌 값 = 출발지
                    int next_w = distribution[source] + weight; //현재 노드까지의 가중치 + 인접 정점 가중치

                    if(next_w < distribution[target]){ //인접 정점 가중치가 경로 누적 가중치보다 작으면 갱신
                        distribution[target] = next_w;
                    }
                }
            }
        }

        for(Node node : nodeList){
            int source = node.source;
            int target = node.target;
            int weight = node.weigth;

            if(distribution[source] != Integer.MAX_VALUE && distribution[source] + weight < distribution[target]){
                System.out.println("contains negative w cycle");
                return;
            }
        }

        printPath(distribution);
    }

    private void printPath(int[] distribution) {
        for (int i = 0; i < distribution.length; i++) {
            System.out.println(i + " : " + distribution[i]);
        }
    }

    static class Node {

        int source;
        int target;
        int weigth;

        public Node(int source, int target, int weight){
            this.source = source;
            this.target = target;
            this.weigth = weight;
        }

    }

    private void addEdge(int source, int target, int weight) {
        Node node = new Node(source, target, weight);
        nodeList.add(node);
    }


    public static void main(String[] args) {

        SampleCode2 sample = new SampleCode2();
        
        sample.addEdge(0, 1, 2);
        sample.addEdge(0, 2, 3);
        sample.addEdge(1, 0, 2);
        sample.addEdge(1, 2, 5);
        sample.addEdge(1, 3, 4);
        sample.addEdge(2, 0, 3);
        sample.addEdge(2, 1, 5);
        sample.addEdge(2, 3, 2);
        sample.addEdge(2, 6, 5);
        sample.addEdge(3, 1, 4);
        sample.addEdge(3, 2, 2);
        sample.addEdge(3, 4, 9);
        sample.addEdge(3, 6, 7);
        sample.addEdge(3, 7, 1);
        sample.addEdge(4, 3, 9);
        sample.addEdge(4, 5, 1);
        sample.addEdge(4, 8, 3);
        sample.addEdge(5, 4, 1);
        sample.addEdge(5, 7, 2);
        sample.addEdge(6, 2, 5);
        sample.addEdge(6, 3, 7);
        sample.addEdge(6, 7, 3);
        sample.addEdge(6, 8, 11);
        sample.addEdge(7, 3, 1);
        sample.addEdge(7, 5, 2);
        sample.addEdge(7, 6, 3);
        sample.addEdge(8, 4, 3);
        sample.addEdge(8, 6, 11);

        sample.bellman(0);

    }
}
